package com.lorenzon.expense_tracker_api.domain.expense;

public enum ExpenseCategory {

    GROCERIES("groceries"),
    LEISURE("leisure"),
    ELECTRONICS("electronics"),
    UTILITIES("utilities"),
    CLOTHING("clothing"),
    HEALTH("health"),
    OTHERS("others");

    private String category;

    ExpenseCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
