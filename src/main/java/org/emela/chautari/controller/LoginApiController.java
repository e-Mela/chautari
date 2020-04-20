package org.emela.chautari.controller;

import org.emela.chautari.api.LoginApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-19T21:21:27.227-04:00[America/New_York]")

@Controller
@RequestMapping("${openapi.chautariRentalService.base-path:/chautari}")
public class LoginApiController implements LoginApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LoginApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
