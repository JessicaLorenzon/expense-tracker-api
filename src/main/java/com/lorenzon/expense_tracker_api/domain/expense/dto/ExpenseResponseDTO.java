package com.lorenzon.expense_tracker_api.domain.expense.dto;

import com.lorenzon.expense_tracker_api.domain.expense.Expense;
import com.lorenzon.expense_tracker_api.domain.expense.ExpenseCategory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ExpenseResponseDTO(UUID id, String description, BigDecimal amount, ExpenseCategory category,
                                 LocalDate expenseDate) {

    public ExpenseResponseDTO(Expense expense) {
        this(expense.getId(), expense.getDescription(), expense.getAmount(), expense.getCategory(), expense.getExpenseDate());
    }
}
