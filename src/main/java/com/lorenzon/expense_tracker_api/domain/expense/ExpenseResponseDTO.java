package com.lorenzon.expense_tracker_api.domain.expense;

import java.math.BigDecimal;
import java.util.UUID;

public record ExpenseResponseDTO(UUID id, String description, BigDecimal amount) {

    public ExpenseResponseDTO(Expense expense) {
        this(expense.getId(), expense.getDescription(), expense.getAmount());
    }
}
