package com.example.springtest.exception;

import com.example.springtest.api.ApiError;
import com.example.springtest.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Catches all controller exceptions and standardizes the output format 
 * using our ApiResponse envelope.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles Spring Bean Validation errors (e.g. @NotBlank, @Size).
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> validationErrors = new HashMap<>();
        
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            validationErrors.put(error.getField(), error.getDefaultMessage())
        );
        
        ApiError apiError = new ApiError("VALIDATION_FAILED", "Invalid request body parameters", validationErrors);
        return ApiResponse.fail(apiError);
    }

    /**
     * Handles any other unhandled runtime exceptions.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Void> handleGenericException(Exception ex) {
        // Warning: in production, you might not want to expose the raw exception message
        ApiError apiError = new ApiError("INTERNAL_SERVER_ERROR", ex.getMessage(), null);
        return ApiResponse.fail(apiError);
    }
}
