package com.lorenzon.expense_tracker_api.domain.user.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @NotBlank
        String login,
        @NotBlank
        String password) {
}
