package com.lorenzon.expense_tracker_api.exceptions.handler;

import com.lorenzon.expense_tracker_api.exceptions.ExpenseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ExpenseNotFoundException.class)
    public ProblemDetail expenseNotFound(ExpenseNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Expense not found");
        problemDetail.setDetail(e.getMessage());
        problemDetail.setType(URI.create("https://expense-tracker-api.com/errors/expense-not-found"));

        return problemDetail;
    }
}
