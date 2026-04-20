package com.example.springtest.service;

import com.example.springtest.dto.GreetingRequest;
import com.example.springtest.dto.GreetingResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GreetingService {

    /**
     * Handles the business logic for greetings.
     */
    public GreetingResponse generateGreeting(GreetingRequest request) {
        // Business logic would go here. For now, it's just formatting a string.
        String message = String.format("Hello, %s!", request.name());
        return new GreetingResponse(message, LocalDateTime.now());
    }
}
