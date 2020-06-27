package org.emela.chautari.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.emela.chautari.model.RentalItemRequest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class ChautariUtils {

    public static RentalItemRequest prepareRentalItemRequest(String fileName)
            throws IOException {
        RentalItemRequest rentalItemRequest = new ObjectMapper().readValue(new ClassPathResource(fileName)
                .getFile(), RentalItemRequest.class);
        return rentalItemRequest;
    }

    public static String getStringPayloadFromObject(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
