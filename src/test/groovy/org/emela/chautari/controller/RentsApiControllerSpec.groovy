package org.emela.chautari.controller

import groovy.json.JsonSlurper
import org.emela.chautari.model.RentalItemRequest
import org.emela.chautari.model.RentalItemResponse
import org.emela.chautari.service.RentalService
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

        //TODO: change request body

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

}
