package org.emela.chautari.controller;

import org.emela.chautari.api.LoginApi;
import org.emela.chautari.model.AuthenticationResponse;
import org.emela.chautari.model.Credential;
import org.emela.chautari.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${openapi.chautariRentalService.base-path:/chautari}")
public class LoginApiController implements LoginApi {

    private CredentialService credentialService;

    @Autowired
    public LoginApiController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Credential credential) {
        AuthenticationResponse response = credentialService.login(credential);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
