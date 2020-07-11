package org.emela.chautari.controller

import groovy.json.JsonSlurper
import org.emela.chautari.model.RentalItemDetail
import org.emela.chautari.model.RentalItemRequest
import org.emela.chautari.model.RentalItemResponse
import org.emela.chautari.service.RentalService
import org.emela.chautari.utils.ChautariUtils
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static groovy.json.JsonOutput.toJson
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [RentsApiController])
class RentsApiControllerSpec extends Specification {

    @Autowired
    private WebApplicationContext webApplicationContext

    @SpringBean
    private RentalService rentalService = Stub();

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
}
