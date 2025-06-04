package com.github.jmgoyesc.javarecap.controllers;

import com.github.jmgoyesc.javarecap.domain.Stats;
import com.github.jmgoyesc.javarecap.domain.TypeStats;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/stats")
public class StatsController {

    @GetMapping
    public Stats get() {
        return Stats.builder()
                .consumer(TypeStats.builder()
                        .messages(143)
                        .count(2)
                        .speed("2 SECONDS")
                        .messagesPerMinute(30)
                        .build())
                .producer(TypeStats.builder()
                        .messages(143)
                        .count(2)
                        .speed("2 SECONDS")
                        .messagesPerMinute(30)
                        .build())
                .build();
    }

}
