package com.lorenzon.expense_tracker_api.domain.expense;

import com.lorenzon.expense_tracker_api.domain.expense.dto.ExpenseRequestDTO;
import com.lorenzon.expense_tracker_api.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "expenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Expense(ExpenseRequestDTO body) {
        this.description = body.description();
        this.amount = body.amount();
    }
}
