package org.emela.chautari.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.emela.chautari.model.RentalItemDetail;
import org.emela.chautari.model.RentalItemRequest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class ChautariUtils {

    private ChautariUtils() {
    }

    public static RentalItemRequest prepareRentalItemRequest(String fileName)
            throws IOException {
        return new ObjectMapper().readValue(new ClassPathResource(fileName)
                .getFile(), RentalItemRequest.class);
    }

    public static RentalItemDetail prepareRentalItemDetail(String fileName)
            throws IOException {
        return new ObjectMapper().readValue(new ClassPathResource(fileName)
                .getFile(), RentalItemDetail.class);
    }

    public static String getStringPayloadFromObject(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }


}
