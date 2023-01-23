package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotNull;

public record TweetsDTO(

    @NotNull
    String username,
    @NotNull
    String tweet
) {
    
}
