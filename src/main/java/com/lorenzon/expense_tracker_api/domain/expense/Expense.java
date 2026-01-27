package com.lorenzon.expense_tracker_api.domain.expense;

import com.lorenzon.expense_tracker_api.domain.expense.dto.ExpenseRequestDTO;
import com.lorenzon.expense_tracker_api.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
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

    @Enumerated(EnumType.STRING)
    private ExpenseCategory category;

    private LocalDate expenseDate;

    @CreationTimestamp
    @Column(updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Expense(ExpenseRequestDTO body) {
        this.description = body.description();
        this.amount = body.amount();
        this.category = body.category();
        this.expenseDate = body.expenseDate();
    }

    public Expense(Expense expense, User user) {
        this.description = expense.getDescription();
        this.amount = expense.getAmount();
        this.category = expense.getCategory();
        this.expenseDate = expense.getExpenseDate();
        this.user = user;
    }
}
