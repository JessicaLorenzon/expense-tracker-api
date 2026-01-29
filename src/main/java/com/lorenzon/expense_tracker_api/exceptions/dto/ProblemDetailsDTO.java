package com.lorenzon.expense_tracker_api.exceptions.dto;

public record ProblemDetailsDTO(Integer status, String title, String detail, String type, String instance) {
}
