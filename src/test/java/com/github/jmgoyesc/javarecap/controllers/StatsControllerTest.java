package com.github.jmgoyesc.javarecap.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StatsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGet_ReturnsStatsObject() throws Exception {
        mockMvc.perform(get("/v1/stats")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.consumer.messages", is(143)))
                .andExpect(jsonPath("$.consumer.count", is(2)))
                .andExpect(jsonPath("$.consumer.speedInSeconds", is(2)))
                .andExpect(jsonPath("$.consumer.messagesPerMinute", is(30)))
                .andExpect(jsonPath("$.producer.messages", is(143)))
                .andExpect(jsonPath("$.producer.count", is(2)))
                .andExpect(jsonPath("$.producer.speedInSeconds", is(2)))
                .andExpect(jsonPath("$.producer.messagesPerMinute", is(30)));
    }
}