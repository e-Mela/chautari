package org.emela.chautari.controller;

import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.emela.chautari.api.SetupApi;
import org.emela.chautari.model.SetupResponse;
import org.emela.chautari.model.UserAccountDetail;
import org.emela.chautari.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j
@RestController
@RequestMapping("${openapi.chautariRentalService.base-path:/chautari}")
public class SetupApiController implements SetupApi {

    private final SetupService setupService;

    @Autowired
    public SetupApiController(SetupService setupService) {
        this.setupService = setupService;
    }

    @Override
    public ResponseEntity<SetupResponse> setUpUserAccount(@ApiParam(value = "setup request body") @Valid @RequestBody UserAccountDetail userAccountDetail) {
        //log.info("processing new user as: "+ userAccountDetail.getUser().getPerson().getFirstName());
        return new ResponseEntity<>(setupService.setupUser(userAccountDetail), HttpStatus.OK);
    }


}
