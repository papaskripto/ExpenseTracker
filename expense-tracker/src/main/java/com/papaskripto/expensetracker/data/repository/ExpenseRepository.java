package com.papaskripto.expensetracker.data.repository;

import com.papaskripto.expensetracker.data.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, UUID> {
}
