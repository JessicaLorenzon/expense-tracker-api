package com.lorenzon.expense_tracker_api.domain.expense.dto;

import com.lorenzon.expense_tracker_api.domain.expense.Expense;

import java.math.BigDecimal;
import java.util.UUID;

public record ExpenseResponseDTO(UUID id, String description, BigDecimal amount) {

    public ExpenseResponseDTO(Expense expense) {
        this(expense.getId(), expense.getDescription(), expense.getAmount());
    }
}
