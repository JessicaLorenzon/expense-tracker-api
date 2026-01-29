package com.lorenzon.expense_tracker_api.controllers;

import com.lorenzon.expense_tracker_api.domain.expense.Expense;
import com.lorenzon.expense_tracker_api.domain.expense.ExpensePeriod;
import com.lorenzon.expense_tracker_api.domain.expense.dto.ExpenseRequestDTO;
import com.lorenzon.expense_tracker_api.domain.expense.dto.ExpenseResponseDTO;
import com.lorenzon.expense_tracker_api.exceptions.InvalidPeriodException;
import com.lorenzon.expense_tracker_api.services.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<ExpenseResponseDTO>> getAllExpenses(@RequestParam(required = false) String period,
                                                                   @RequestParam(required = false) LocalDate startDate,
                                                                   @RequestParam(required = false) LocalDate endDate) {
        List<Expense> expenses;

        if (period != null) {
            if (startDate != null || endDate != null) {
                throw new InvalidPeriodException();
            }
            ExpensePeriod expensePeriod = ExpensePeriod.from(period);
            expenses = expenseService.findByFilter(expensePeriod);

        } else if (startDate != null || endDate != null) {
            if (startDate == null || endDate == null) {
                throw new InvalidPeriodException();
            }
            expenses = expenseService.findByCustom(startDate, endDate);

        } else {
            expenses = expenseService.findAll();
        }

        List<ExpenseResponseDTO> response = expenses.stream().map(x -> new ExpenseResponseDTO(x)).toList();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ExpenseResponseDTO> createExpense(@RequestBody @Valid ExpenseRequestDTO body) {
        Expense newExpense = new Expense(body);
        ExpenseResponseDTO response = new ExpenseResponseDTO(expenseService.insert(newExpense));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{expenseId}")
    public ResponseEntity<ExpenseResponseDTO> updateExpense(@PathVariable UUID expenseId, @RequestBody @Valid ExpenseRequestDTO body) {
        Expense updatedExpense = new Expense(body);
        ExpenseResponseDTO response = new ExpenseResponseDTO(expenseService.update(expenseId, updatedExpense));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{expenseId}")
    public ResponseEntity<Void> deleteExpense(@PathVariable UUID expenseId) {
        expenseService.delete(expenseId);

        return ResponseEntity.noContent().build();
    }
}
