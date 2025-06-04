package com.github.jmgoyesc.javarecap.controllers;

import com.github.jmgoyesc.javarecap.domain.ChannelConfig;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/producers")
public class ProducerController {

    @PostMapping
    public void set(@RequestBody ChannelConfig config) {

    }

}
