package com.github.jmgoyesc.javarecap.domain;

import lombok.Builder;
import lombok.With;

@Builder @With
public record ChannelConfig(
        int count,
        DurationConfig speed
) {
}
