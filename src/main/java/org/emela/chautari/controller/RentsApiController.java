package org.emela.chautari.controller;

import org.emela.chautari.api.RentsApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-18T09:53:05.107-04:00[America/New_York]")

@Controller
@RequestMapping("${openapi.chautariRentalService.base-path:/chautari}")
public class RentsApiController implements RentsApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RentsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
