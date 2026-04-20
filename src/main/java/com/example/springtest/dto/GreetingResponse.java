package com.example.springtest.dto;

import java.time.LocalDateTime;

public record GreetingResponse(
        String message,
        LocalDateTime generatedAt
) {
}
