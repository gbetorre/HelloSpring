package com.example.springtest.controller;

import com.example.springtest.api.ApiResponse;
import com.example.springtest.dto.GreetingRequest;
import com.example.springtest.dto.GreetingResponse;
import com.example.springtest.service.GreetingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /**
     * Endpoint to demonstrate request and response handling.
     * Use POST to submit a GreetingRequest in the request body.
     */
    @PostMapping
    public ApiResponse<GreetingResponse> greet(@Valid @RequestBody GreetingRequest request) {
        GreetingResponse response = greetingService.generateGreeting(request);
        return ApiResponse.ok(response);
    }
    
    /**
     * Simple GET endpoint to verify the API is up.
     */
    @GetMapping("/ping")
    public ApiResponse<String> ping() {
        return ApiResponse.ok("pong");
    }
}
