package com.github.jmgoyesc.javarecap.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jmgoyesc.javarecap.domain.ChannelConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProducerController.class)
public class ProducerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Test for creating a valid configuration.
     */
    @Test
    void shouldReturnOkWhenValidConfigIsProvided() throws Exception {
        ChannelConfig validConfig = ChannelConfig.builder()
                .count(10)
                .speedInSeconds(5)
                .build();

        mockMvc.perform(post("/v1/producers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validConfig)))
                .andExpect(status().isOk());
    }

    /**
     * Test for invalid configuration with negative count.
     */
    @Test
    void shouldReturnBadRequestWhenCountIsNegative() throws Exception {
        ChannelConfig invalidConfig = ChannelConfig.builder()
                .count(-1)
                .speedInSeconds(5)
                .build();

        mockMvc.perform(post("/v1/producers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidConfig)))
                .andExpect(status().isBadRequest());
    }

    /**
     * Test for invalid configuration with negative speedInSeconds.
     */
    @Test
    void shouldReturnBadRequestWhenSpeedIsNegative() throws Exception {
        ChannelConfig invalidConfig = ChannelConfig.builder()
                .count(10)
                .speedInSeconds(-5)
                .build();

        mockMvc.perform(post("/v1/producers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidConfig)))
                .andExpect(status().isBadRequest());
    }

    /**
     * Test for invalid configuration with both negative values.
     */
    @Test
    void shouldReturnBadRequestWhenBothValuesAreNegative() throws Exception {
        ChannelConfig invalidConfig = ChannelConfig.builder()
                .count(-10)
                .speedInSeconds(-5)
                .build();

        mockMvc.perform(post("/v1/producers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidConfig)))
                .andExpect(status().isBadRequest());
    }

    /**
     * Test for missing request body.
     */
    @Test
    void shouldReturnBadRequestWhenRequestBodyIsMissing() throws Exception {
        mockMvc.perform(post("/v1/producers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}