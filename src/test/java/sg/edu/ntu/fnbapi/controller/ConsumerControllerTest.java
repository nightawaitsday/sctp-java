package sg.edu.ntu.fnbapi.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import sg.edu.ntu.fnbapi.entity.Consumer;

@SpringBootTest
@AutoConfigureMockMvc
public class ConsumerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Get consumer by Id")
    @Test
    public void getConsumerbyIdTest() throws Exception {
    // Build a GET request
    RequestBuilder request = MockMvcRequestBuilders.get("/consumers/1");

    // Perform the request
    mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.id").value(1));
    }

    // @Test
    // public void getAllConsumersTest() throws Exception {
    // //Build a GET request
    // RequestBuilder request = MockMvcRequestBuilders.get("/consumers");

    // //Perform the request
    // mockMvc.perform(request)
    // .andExpect(status().isOk())
    // .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    // .andExpect(jsonPath("$.size()").value(5));
    // }

    // @Autowired
    // private ObjectMapper objectMapper;

    // @Test
    // public void validConsumerCreationTest() throws Exception {
    // // Create consumer object
    // Consumer newConsumer =
    // Consumer.builder().firstName("Paul").lastName("Low").email("paullow@outlook.com")
    // .build();

    // // Step 2: Convert the Java object to JSON using ObjectMapper
    // String newConsumerAsJSON = objectMapper.writeValueAsString(newConsumer);

    // // Step 3: Build the request
    // RequestBuilder request = MockMvcRequestBuilders.post("/consumers")
    // .contentType(MediaType.APPLICATION_JSON)
    // .content(newConsumerAsJSON);

    // // Step 4: Perform the request and get the response and assert
    // mockMvc.perform(request)
    // .andExpect(status().isCreated())
    // .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    // .andExpect(jsonPath("$.id").value(4))
    // .andExpect(jsonPath("$.firstName").value("Paul"))
    // .andExpect(jsonPath("$.lastName").value("Low"));
    // }

    // @Test
    // public void invalidConsumerCreationTest() throws Exception {
    // // Step 1: Create a Customer object with invalid fields
    // Consumer invalidConsumer = new Consumer(" ", " ", "anyoutlook.com");

    // // Step 2: Convert the Java object to JSON
    // String invalidConsumerAsJSON =
    // objectMapper.writeValueAsString(invalidConsumer);

    // // Step 3: Build the request
    // RequestBuilder request = MockMvcRequestBuilders.post("/consumers")
    // .contentType(MediaType.APPLICATION_JSON)
    // .content(invalidConsumerAsJSON);

    // // Step 4: Perform the request and get the response
    // mockMvc.perform(request)
    // .andExpect(status().isBadRequest())
    // .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    // }

}
