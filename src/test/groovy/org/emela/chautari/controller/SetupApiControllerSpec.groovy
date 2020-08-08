package org.emela.chautari.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.emela.chautari.model.*
import org.emela.chautari.service.SetupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = SetupApiController.class)
@AutoConfigureMockMvc
class SetupApiControllerSpec extends Specification {
    @Autowired
    private WebApplicationContext webApplicationContext

    @MockBean
    SetupService setupService

    @Autowired
    ObjectMapper objectMapper

    private MockMvc mockMvc

    def 'setup'() {
        //Init MockMvc Object and build
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }


    def 'user should use /setup to create new user'() {
        given:
        UserAccountDetail userDetail = new UserAccountDetail()
        setupService.setupUser(_ as UserAccountDetail) >> new SetupResponse().message('success')

        when:
        def results = mockMvc.perform((post('/chautari/setup')
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDetail))))

        then:
        results.andExpect(status().isOk())
    }

}
