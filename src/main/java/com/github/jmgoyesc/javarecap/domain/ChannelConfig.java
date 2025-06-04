package com.github.jmgoyesc.javarecap.domain;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.With;

@Builder @With
public record ChannelConfig(
        @Min(0) int count,
        @Min(0) int speedInSeconds
) {
}
