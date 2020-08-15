//package org.emela.chautari.controller
//
//import org.emela.chautari.model.Review
//import org.emela.chautari.model.Reviews
//import org.emela.chautari.service.ReviewService
//import org.spockframework.spring.SpringBean
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//import org.springframework.http.MediaType
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.setup.MockMvcBuilders
//import org.springframework.web.context.WebApplicationContext
//import spock.lang.Specification
//
//import static groovy.json.JsonOutput.toJson
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
//
//@WebMvcTest(controllers = [ReviewApiController])
//class ReviewApiControllerSpec extends Specification {
//
//
//    @Autowired
//    private WebApplicationContext webApplicationContext
//
//    @SpringBean
//    private ReviewService reviewService = Stub()
//
//
//    private MockMvc mockMvc
//
//
//    void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
//    }
//
//
//    def 'Should add review with valid review request'() {
//
//        given:
//        Review review = new Review().comment("one of the best room").star(4).reviewer("test-reviewer")
//        reviewService.addReview(_ as String, _ as Review) >> new Review().comment('one of the best room')
//                .star(4)
//
//        when:
//        def response = mockMvc.perform(
//                post('/chautari/rents/test-rental-id/reviews')
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(toJson(review)))
//
//        then:
//        response.andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath('$.comment').value("one of the best room"))
//                .andExpect(jsonPath('$.star').value(4))
//
//    }
//
//    def 'Should return review summary for valid rental item'() {
//
//        given:
//        reviewService.getReviews(_ as String) >> new Reviews().averageLike(new BigDecimal("4.5")).addReviewsItem(new
//                Review().comment("comment-1").star(5)).addReviewsItem(new Review().comment("comment-2").star(4))
//        when:
//        def response = mockMvc.perform(get('/chautari/rents/3793cb49-8ae7-440c-918c-48ae6d621fa4/reviews')
//                .contentType(MediaType.APPLICATION_JSON))
//
//
//        then:
//        response.andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath('$.average-like').value(4.5))
//                .andExpect(jsonPath('$.reviews[0].comment').value("comment-1"))
//                .andExpect(jsonPath('$.reviews[0].star').value(5))
//                .andExpect(jsonPath('$.reviews[1].comment').value("comment-2"))
//                .andExpect(jsonPath('$.reviews[1].star').value(4))
//
//    }
//
//
//    def 'Should return review for specific review id'() {
//
//        given:
//        reviewService.getReview(_ as String, _ as String) >> new Review().comment("comment-1").star(5)
//        when:
//        def response = mockMvc.perform(get('/chautari/rents/3793cb49-8ae7-440c-918c-48ae6d621fa4/reviews/test-review' +
//                '-id')
//                .contentType(MediaType.APPLICATION_JSON))
//
//
//        then:
//        response.andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath('$.comment').value("comment-1"))
//                .andExpect(jsonPath('$.star').value(5))
//
//    }
//
//    def 'Should delete review for specific review id'() {
//
//        given:
//
//        when:
//        def response = mockMvc.perform(delete('/chautari/rents/3793cb49-8ae7-440c-918c-48ae6d621fa4/reviews/test-review' +
//                '-id')
//                .contentType(MediaType.APPLICATION_JSON))
//
//
//        then:
//        response.andDo(print())
//                .andExpect(status().isOk())
//    }
//
//    def 'Should update review with valid review request'() {
//
//        given:
//        Review review = new Review().comment("one of the best room").star(4).reviewer("test-reviewer")
//        reviewService.updateReview(_ as String, _ as String, _ as Review) >> new Review().comment('one of the best ' +
//                'room')
//                .star(4)
//
//        when:
//        def response = mockMvc.perform(put('/chautari/rents/test-rental-id/reviews/test-review-id')
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(toJson(review)))
//
//        then:
//        response.andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath('$.comment').value("one of the best room"))
//                .andExpect(jsonPath('$.star').value(4))
//
//    }
//
//}
