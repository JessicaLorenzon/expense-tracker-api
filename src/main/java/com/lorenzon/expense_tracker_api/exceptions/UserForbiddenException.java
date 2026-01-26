package com.lorenzon.expense_tracker_api.exceptions;

public class UserForbiddenException extends RuntimeException {

    public UserForbiddenException() {
        super("User forbidden");
    }
}
