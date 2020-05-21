package org.emela.chautari.controller;

import lombok.extern.log4j.Log4j;
import org.emela.chautari.model.SetupResponse;
import org.emela.chautari.model.UserDetail;
import org.emela.chautari.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RestController
@RequestMapping("${openapi.chautariRentalService.base-path:/chautari}")
public class SetupApiController {
    private SetupService setupService;

    @Autowired
    public SetupApiController(SetupService setupService) {
        this.setupService = setupService;
    }

    @PostMapping("/setup")
    public SetupResponse saveUser(@RequestBody UserDetail userDetail) {
        //log.info("processing new user as: "+ userDetail.getPerson().getFirstName());
        return setupService.setupUser(userDetail);
    }


}
