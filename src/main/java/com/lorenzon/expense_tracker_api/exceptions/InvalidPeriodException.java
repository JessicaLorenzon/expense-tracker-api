package com.lorenzon.expense_tracker_api.exceptions;

public class InvalidPeriodException extends RuntimeException{

    public InvalidPeriodException() {
        super ("Filter with invalid period");
    }
}
