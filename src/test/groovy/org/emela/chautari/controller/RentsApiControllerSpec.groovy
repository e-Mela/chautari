package org.emela.chautari.controller

import groovy.json.JsonSlurper
import org.emela.chautari.model.*
import org.emela.chautari.service.RentalService
import org.emela.chautari.service.ResourceService
import org.emela.chautari.service.ReviewService
import org.emela.chautari.utils.ChautariUtils
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static groovy.json.JsonOutput.toJson
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [RentsApiController])
class RentsApiControllerSpec extends Specification {

    @Autowired
    private WebApplicationContext webApplicationContext

    @SpringBean
    private RentalService rentalService = Stub()

    @SpringBean
    private ReviewService reviewService = Stub()

    @MockBean
    private ResourceService resourceService

    private MockMvc mockMvc


    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    def "should create rental item on valid rental request"() {


        given:
        def jsonSlurper = new JsonSlurper()
        Object reqObject = jsonSlurper.parse(new File('./src/test/resources/inputs/rent-post-request.json'))
        rentalService.createRental(_ as RentalItemRequest) >> new RentalItemResponse().rentalId("3793cb49-8ae7-440c-918c-48ae6d621fa4")

        when:
        def response = mockMvc.perform(
                post('/chautari/rents')
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(reqObject)))

        then:
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.rental-id').value("3793cb49-8ae7-440c-918c-48ae6d621fa4"))
    }

    def "should throw exception on invalid rental request"() {

        given:
        Object reqObject = null

        when:
        def response = mockMvc.perform(
                post('/chautari/rents')
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(reqObject)))

        then:
        response.andDo(print())
                .andExpect(status().isBadRequest())
    }


    def "should retrieve rental item details on GET rental item"() {
        given:
        rentalService.getRentalItemDetail(_ as String) >> ChautariUtils.prepareRentalItemDetail('inputs/rent-get-response.json')

        when:
        def response = mockMvc.perform(get('/chautari/rents/3793cb49-8ae7-440c-918c-48ae6d621fa4')
                .contentType(MediaType.APPLICATION_JSON))


        then:
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.title').value("Room 101"))
                .andExpect(jsonPath('$.rentOf').value("room"))
                .andExpect(jsonPath('$.availability[0].available').value(true))
                .andExpect(jsonPath('$.price.value').value(12.23))
                .andExpect(jsonPath('$.price.negotiable').value(true))
                .andExpect(jsonPath('$.preferences[0].preference').value('Hot girl only'))
                .andExpect(jsonPath('$.features[0].feature').value('Washer & Dryer included'))
    }

    def 'should create new resource for a given user and rental-id on POST uploadResource'() {
        given:
        MockMultipartFile firstFile = new MockMultipartFile("picture_1", "picture_1.jpg", "text/plain", "fake_picture_1".getBytes())
        MockMultipartFile secondFile = new MockMultipartFile("picture_2", "picture_2.png", "text/plain", "fake_picture_2".getBytes())

        when:
        String response = mockMvc.perform(MockMvcRequestBuilders.multipart("/chautari/rents/rental-id/resource")
                .file(firstFile)
                .file(secondFile)
                .header("user-id", "fake-user-id"))
                .andExpect(status().is(200))

        then:
        response != null
    }

    def 'Should add review with valid review request'() {

        given:
        Review review = new Review().comment("one of the best room").star(4).reviewer("test-reviewer")
        reviewService.addReview(_ as String, _ as Review) >> new ReviewResponse().reviewId('review-id1')


        when:
        def response = mockMvc.perform(
                post('/chautari/rents/test-rental-id/reviews')
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(review)))

        then:
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.review-id').value("review-id1"))

    }

    def 'Should fail add review operation with invalid review request'() {

        given:
        Review emptyReview = new Review()
        reviewService.addReview(_ as String, _ as Review) >> new ReviewResponse().reviewId('review-id1')


        when:
        def response = mockMvc.perform(
                post('/chautari/rents/test-rental-id/reviews')
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(emptyReview)))

        then:
        response.andDo(print())
                .andExpect(status().isBadRequest())
    }

    def 'Should return review summary for valid rental item'() {

        given:
        reviewService.getReviews(_ as String) >> new Reviews().averageLike(new BigDecimal("4.5")).addReviewsItem(new
                Review().comment("comment-1").star(5)).addReviewsItem(new Review().comment("comment-2").star(4))
        when:
        def response = mockMvc.perform(get('/chautari/rents/3793cb49-8ae7-440c-918c-48ae6d621fa4/reviews')
                .contentType(MediaType.APPLICATION_JSON))


        then:
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.average-like').value(4.5))
                .andExpect(jsonPath('$.reviews[0].comment').value("comment-1"))
                .andExpect(jsonPath('$.reviews[0].star').value(5))
                .andExpect(jsonPath('$.reviews[1].comment').value("comment-2"))
                .andExpect(jsonPath('$.reviews[1].star').value(4))

    }


    def 'Should return review for specific review id'() {

        given:
        reviewService.getReview(_ as String, _ as String) >> new Review().comment("comment-1").star(5)
        when:
        def response = mockMvc.perform(get('/chautari/rents/3793cb49-8ae7-440c-918c-48ae6d621fa4/reviews/test-review' +
                '-id')
                .contentType(MediaType.APPLICATION_JSON))


        then:
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.comment').value("comment-1"))
                .andExpect(jsonPath('$.star').value(5))

    }

    def 'Should delete review for specific review id'() {

        given:

        when:
        def response = mockMvc.perform(delete('/chautari/rents/3793cb49-8ae7-440c-918c-48ae6d621fa4/reviews/test-review' +
                '-id')
                .contentType(MediaType.APPLICATION_JSON))


        then:
        response.andDo(print())
                .andExpect(status().isOk())
    }

    def 'Should update review with valid review request'() {

        given:
        Review review = new Review().comment("one of the best room").star(4).reviewer("test-reviewer")
        reviewService.updateReview(_ as String, _ as String, _ as Review) >> new ReviewResponse().reviewId('review-id-1')


        when:
        def response = mockMvc.perform(put('/chautari/rents/test-rental-id/reviews/test-review-id')
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(review)))

        then:
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.review-id').value("review-id-1"))

    }
    
}