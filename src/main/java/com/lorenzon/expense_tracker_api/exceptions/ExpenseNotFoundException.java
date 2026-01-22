package com.lorenzon.expense_tracker_api.exceptions;

import java.util.UUID;

public class ExpenseNotFoundException extends RuntimeException {

    public ExpenseNotFoundException(UUID id) {
        super("Expense white id " + id + " not found");
    }
}
