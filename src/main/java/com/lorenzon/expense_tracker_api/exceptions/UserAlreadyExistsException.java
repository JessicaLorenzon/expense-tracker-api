package com.lorenzon.expense_tracker_api.exceptions;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException() {
        super ("User already exists");
    }
}
