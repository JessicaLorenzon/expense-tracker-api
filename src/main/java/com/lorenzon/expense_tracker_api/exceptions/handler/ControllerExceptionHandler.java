package com.lorenzon.expense_tracker_api.exceptions.handler;

import com.lorenzon.expense_tracker_api.exceptions.ExpenseNotFoundException;
import com.lorenzon.expense_tracker_api.exceptions.InvalidPeriodException;
import com.lorenzon.expense_tracker_api.exceptions.UserAlreadyExistsException;
import com.lorenzon.expense_tracker_api.exceptions.UserForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.net.URI;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ExpenseNotFoundException.class)
    public ProblemDetail expenseNotFoundException(ExpenseNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Expense not found");
        problemDetail.setDetail(e.getMessage());
        problemDetail.setType(URI.create("https://expense-tracker-api.com/errors/expense-not-found"));

        return problemDetail;
    }

    @ExceptionHandler(UserForbiddenException.class)
    public ProblemDetail userForbiddenException(UserForbiddenException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.FORBIDDEN);
        problemDetail.setTitle("User forbidden");
        problemDetail.setDetail(e.getMessage());
        problemDetail.setType(URI.create("https://expense-tracker-api.com/errors/user-forbidden"));

        return problemDetail;
    }

    @ExceptionHandler(InvalidPeriodException.class)
    public ProblemDetail invalidPeriodException(InvalidPeriodException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Invalid period");
        problemDetail.setDetail(e.getMessage());
        problemDetail.setType(URI.create("https://expense-tracker-api.com/errors/invalid-period"));

        return problemDetail;
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ProblemDetail userAlreadyExistsException(UserAlreadyExistsException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("User conflict");
        problemDetail.setDetail(e.getMessage());
        problemDetail.setType(URI.create("https://expense-tracker-api.com/errors/user-conflict"));

        return problemDetail;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ProblemDetail methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Invalid period");
        problemDetail.setDetail("Filter with invalid period");
        problemDetail.setType(URI.create("https://expense-tracker-api.com/errors/invalid-period"));

        return problemDetail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail methodArgumentNotValidException(MethodArgumentNotValidException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Invalid fields");
        problemDetail.setDetail("Field(s) with invalid value(s)");
        problemDetail.setType(URI.create("https://expense-tracker-api.com/errors/invalid-fields"));

        return problemDetail;
    }
}
