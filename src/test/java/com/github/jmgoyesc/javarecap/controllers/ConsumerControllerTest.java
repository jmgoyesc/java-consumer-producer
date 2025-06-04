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

@WebMvcTest(ConsumerController.class)
class ConsumerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void set_shouldReturnOk_whenValidChannelConfigProvided() throws Exception {
        ChannelConfig validConfig = ChannelConfig.builder()
                .count(10)
                .speedInSeconds(5)
                .build();

        mockMvc.perform(post("/v1/consumers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validConfig)))
                .andExpect(status().isOk());
    }

    @Test
    void set_shouldReturnBadRequest_whenInvalidChannelConfigProvided() throws Exception {
        ChannelConfig invalidConfig = ChannelConfig.builder()
                .count(-1)
                .speedInSeconds(5)
                .build();

        mockMvc.perform(post("/v1/consumers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidConfig)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void set_shouldReturnOk_whenCountIsZeroAndSpeedIsValid() throws Exception {
        ChannelConfig zeroCountConfig = ChannelConfig.builder()
                .count(0)
                .speedInSeconds(3)
                .build();

        mockMvc.perform(post("/v1/consumers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(zeroCountConfig)))
                .andExpect(status().isOk());
    }

    @Test
    void set_shouldReturnUnsupportedMediaType_whenContentTypeIsNotJson() throws Exception {
        ChannelConfig validConfig = ChannelConfig.builder()
                .count(1)
                .speedInSeconds(2)
                .build();

        mockMvc.perform(post("/v1/consumers")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content(objectMapper.writeValueAsString(validConfig)))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    void set_shouldReturnBadRequest_whenRequestBodyIsMissing() throws Exception {
        mockMvc.perform(post("/v1/consumers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}