package com.lorenzon.expense_tracker_api.domain.expense;

import com.lorenzon.expense_tracker_api.exceptions.InvalidPeriodException;

public enum ExpensePeriod {
    PAST_WEEK("past-week"),
    PAST_MONTH("past-month"),
    LAST_3_MONTHS("last-3-months");

    private String period;

    ExpensePeriod(String period) {
        this.period = period;
    }

    public static ExpensePeriod from(String period) {
        for (ExpensePeriod p : values()) {
            if (p.period.equalsIgnoreCase(period)) {
                return p;
            }
        }
        throw new InvalidPeriodException();
    }
}
