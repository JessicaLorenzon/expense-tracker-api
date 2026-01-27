package com.lorenzon.expense_tracker_api.services;

import com.lorenzon.expense_tracker_api.domain.expense.Expense;
import com.lorenzon.expense_tracker_api.domain.user.User;
import com.lorenzon.expense_tracker_api.exceptions.ExpenseNotFoundException;
import com.lorenzon.expense_tracker_api.exceptions.UserForbiddenException;
import com.lorenzon.expense_tracker_api.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> findAll() {
        User user = getAuthenticatedUser();

        return expenseRepository.findAllByUser(user);
    }

    @Transactional
    public Expense insert(Expense expense) {
        User user = getAuthenticatedUser();

        Expense newExpense = new Expense(expense, user);

        return expenseRepository.save(newExpense);
    }

    @Transactional
    public Expense update(UUID expenseId, Expense updatedExpense) {
        Expense expense = findById(expenseId);

        checkIfUserIsOwner(expense);

        expense.setDescription(updatedExpense.getDescription());
        expense.setAmount(updatedExpense.getAmount());
        expense.setCategory(updatedExpense.getCategory());
        expense.setExpenseDate(updatedExpense.getExpenseDate());

        return expense;
    }

    @Transactional
    public void delete(UUID expenseId) {
        Expense expense = findById(expenseId);

        checkIfUserIsOwner(expense);

        expenseRepository.delete(expense);
    }

    private Expense findById(UUID expenseId) {
        return expenseRepository.findById(expenseId).orElseThrow(() -> new ExpenseNotFoundException(expenseId));
    }

    private User getAuthenticatedUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof User)) {
            throw new UserForbiddenException();
        }

        return (User) authentication.getPrincipal();
    }

    private void checkIfUserIsOwner(Expense expense) {
        User loggedUser = getAuthenticatedUser();

        if (!expense.getUser().getId().equals(loggedUser.getId())) {
            throw new UserForbiddenException();
        }
    }
}
