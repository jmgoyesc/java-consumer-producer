package com.github.jmgoyesc.javarecap.domain;

import lombok.Builder;
import lombok.With;

@Builder @With
public record TypeStats(
        int messages,
        int count,
        int speedInSeconds,
        int messagesPerMinute
) {
}
