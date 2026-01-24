package com.lorenzon.expense_tracker_api.services;

import com.lorenzon.expense_tracker_api.domain.expense.Expense;
import com.lorenzon.expense_tracker_api.exceptions.ExpenseNotFoundException;
import com.lorenzon.expense_tracker_api.repositories.ExpenseRepository;
import com.lorenzon.expense_tracker_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    @Transactional
    public Expense insert(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Transactional
    public Expense update(UUID expenseId, Expense updateExpense) {
        Expense expense = findById(expenseId);

        expense.setDescription(updateExpense.getDescription());
        expense.setAmount(updateExpense.getAmount());

        return expense;
    }

    @Transactional
    public void delete(UUID expenseId) {
        Expense expense = findById(expenseId);

        expenseRepository.delete(expense);
    }

    private Expense findById(UUID expenseId) {
        return expenseRepository.findById(expenseId).orElseThrow(() -> new ExpenseNotFoundException(expenseId));
    }

}
