package com.papaskripto.expensetracker.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "EXPENSES")

public class ExpenseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)

    @Column (name = "EXPENSE_ID")
    private UUID expenseId;

    @Column (name = "ITEM")
    private String item;

    @Column (name = "AMOUNT")
    private float amount;

    @Column (name = "EXPENSE_DATE")
    private Date expenseDate;

    @Column (name = "NOTES")
    private String notes;

    @Column (name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column (name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}