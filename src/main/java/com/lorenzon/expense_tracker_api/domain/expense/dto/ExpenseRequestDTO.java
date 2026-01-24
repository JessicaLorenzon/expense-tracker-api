package com.lorenzon.expense_tracker_api.domain.expense.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ExpenseRequestDTO(

        @NotBlank
        String description,
        @NotNull
        @Positive
        BigDecimal amount) {
}
