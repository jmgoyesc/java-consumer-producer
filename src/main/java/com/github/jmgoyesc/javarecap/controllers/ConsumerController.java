package com.github.jmgoyesc.javarecap.controllers;

import com.github.jmgoyesc.javarecap.domain.ChannelConfig;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/consumers")
public class ConsumerController {

    @PostMapping
    public void set(@RequestBody @Valid ChannelConfig config){

    }

}
