package com.github.jmgoyesc.javarecap.domain;

import lombok.Builder;
import lombok.With;

import java.time.temporal.TemporalUnit;

@Builder @With
public record DurationConfig(
        int value,
        TemporalUnit unit
) {
}
