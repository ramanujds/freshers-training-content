package com.mynotes.dto;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        String message,
        int status,
        String error,
        LocalDateTime time,
        String path) {
}
