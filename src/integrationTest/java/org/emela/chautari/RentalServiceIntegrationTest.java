package org.emela.chautari;


import lombok.extern.log4j.Log4j2;
import org.emela.chautari.utils.ChautariUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChautariApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Log4j2
@TestPropertySource(locations = "classpath:integration-test.properties")
public class RentalServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHealth() throws Exception {
        String expectResponse = "{\n" +
                "    \"status\": \"UP\"\n" +
                "}";
        this.mockMvc.perform(get("/chautari-health"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectResponse));
    }

    @Test
    public void testCreateRentalItem() throws Exception {
        String fileName = "input/create-rental-item-request.json";
//        String requestJson = ChautariUtils.getStringPayloadFromObject(ChautariUtils.prepareRentalItemRequest(fileName));
//        this.mockMvc.perform(post("/rents"))
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(requestJson))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$['rental-id']").value("ass-sdfad-werwe-werew"));
    }


    @Test
    public void testGetRentalItem() throws Exception {
        String fileName = "input/create-rental-item-request.json";
        String requestJson = ChautariUtils.getStringPayloadFromObject(ChautariUtils.prepareRentalItemRequest(fileName));
//        this.mockMvc.perform(get("/rents/ass-sdfad-werwe-werew"))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$['rental-id']").value("ass-sdfad-werwe-werew"))
//                .andExpect(jsonPath("$['rentOf']").value("room"))
//                .andExpect(jsonPath("$['']").value(""))
//                .andExpect(jsonPath("$['']").value(""));
    }

    @Test
    public void testUpdateRentalItem() throws Exception {
        String fileName = "input/create-rental-item-request.json";
        String requestJson = ChautariUtils.getStringPayloadFromObject(ChautariUtils.prepareRentalItemRequest(fileName));
//        this.mockMvc.perform(get("/rents/ass-sdfad-werwe-werew"))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$['rental-id']").value("ass-sdfad-werwe-werew"));
    }


}
