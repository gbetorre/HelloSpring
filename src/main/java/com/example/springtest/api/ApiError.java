package com.example.springtest.api;

/**
 * Standardized API Error format.
 *
 * @param code    domain-specific error code or HTTP status
 * @param message human-readable description
 * @param details optional additional info or validation errors
 */
public record ApiError(
        String code,
        String message,
        Object details
) {
}
