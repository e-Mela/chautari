package org.emela.chautari.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.emela.chautari.model.AuthenticationResponse
import org.emela.chautari.model.Credential
import org.emela.chautari.service.CredentialService
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

@WebMvcTest(controllers = LoginApiController.class)
@AutoConfigureMockMvc
class LoginApiControllerITSpec extends Specification {
    @Autowired
    private WebApplicationContext webApplicationContext

    @MockBean
    CredentialService credentialService

    @Autowired
    ObjectMapper objectMapper

    private MockMvc mockMvc

    def 'setup' () {
        //Init MockMvc Object and build
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    def 'user should use /login post call to authenticate'() {
        given:
        Credential credential = Credential.builder().userName('fake-user').password('fake-pass').build()

        credentialService.login(_ as Credential) >> AuthenticationResponse.builder().userId('fake it').message('success').build()

        when:
        def results = mockMvc.perform((post('/chautari/login')
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(credential))))

        then:
        results.andExpect(status().isOk())
    }

}
