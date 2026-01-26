package com.lorenzon.expense_tracker_api.repositories;

import com.lorenzon.expense_tracker_api.domain.expense.Expense;
import com.lorenzon.expense_tracker_api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

    List<Expense> findAllByUser(User user);
}
