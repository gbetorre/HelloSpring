package com.example.springtest.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;

/**
 * Generic API envelope returned by every endpoint.
 *
 * <pre>
 * {
 *   "success": true,
 *   "timestamp": "2024-01-01T00:00:00Z",
 *   "data": { ... },            // present on success
 *   "error": null               // present on failure
 * }
 * </pre>
 *
 * @param <T> payload type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
        boolean success,
        Instant timestamp,
        T data,
        ApiError error
) {

    // ── Factory helpers ───────────────────────────────────────────────────────

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(true, Instant.now(), data, null);
    }

    public static <T> ApiResponse<T> fail(ApiError error) {
        return new ApiResponse<>(false, Instant.now(), null, error);
    }
}
