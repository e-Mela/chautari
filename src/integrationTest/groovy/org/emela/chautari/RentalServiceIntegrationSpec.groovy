package org.emela.chautari

import com.fasterxml.jackson.databind.ObjectMapper
import lombok.extern.log4j.Log4j2
import org.emela.chautari.model.RentalItemResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Ignore
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = ChautariApplication, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Log4j2
@TestPropertySource(locations = "classpath:integration-test.properties")
class RentalServiceIntegrationSpec extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Autowired
    ObjectMapper objectMapper


    def 'test chautari application health'() {
        given:
        String expectResponse = "{\n" +
                "    \"status\": \"UP\"\n" +
                "}"
        when:
        def response = this.mockMvc.perform(get("/chautari-health"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectResponse))
        then:
        response != null

    }

    def 'test create rental item with valid request'() {
        given:
        String requestJson = new File('src/integrationTest/resources/input/create-rental-item-request.json').text

        when:
        def response = this.mockMvc.perform(post("/chautari/rents")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())

        then:
        response != null

    }


    def 'test get rental item with valid request'() {
        given:
        String requestJson = new File('src/integrationTest/resources/input/create-rental-item-request.json').text
        def response = this.mockMvc.perform(post("/chautari/rents")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andReturn()

        ObjectMapper objectMapper = new ObjectMapper()
        RentalItemResponse rentalItemResponse = objectMapper.readValue(response.getResponse().getContentAsString(), RentalItemResponse.class)

        when:
        def getResponse = this.mockMvc.perform(get("/chautari/rents/" + rentalItemResponse.rentalId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())

        then:
        getResponse != null

    }

    @Ignore
    //TODO -FIX THIS TEST LATER
    def 'test create rental item resource with valid request'() {
        given:
        byte [] requestJson = new File("src/integrationTest/resources/input/happy.png").bytes

        when:
        String response = mockMvc.perform(MockMvcRequestBuilders.multipart("/chautari/rents/rental-id/resource")
                .file('test-file.jpg', requestJson)
                .header("user-id", "fake-user-id"))
                .andExpect(status().is(200))

        then:
        response != null

    }
}
