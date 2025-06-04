package com.github.jmgoyesc.javarecap.domain;

import lombok.Builder;
import lombok.With;

@Builder @With
public record Stats(TypeStats producer, TypeStats consumer) {
}
