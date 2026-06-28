package com.papaskripto.expensetracker.service;

import com.papaskripto.expensetracker.data.entity.ExpenseEntity;
import com.papaskripto.expensetracker.data.repository.ExpenseRepository;
import com.papaskripto.expensetracker.web.model.Expense;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService (ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> listAllExpenses () {
        List<ExpenseEntity> expenseEntities = this.expenseRepository.findAll();
        List<Expense> expenses = new ArrayList<>(expenseEntities.size ());
        expenseEntities.forEach(expenseEntity -> expenses.add (new Expense(expenseEntity.getExpenseId(),
                expenseEntity.getItem(), expenseEntity.getAmount(), expenseEntity.getExpenseDate(), expenseEntity.getNotes(),
                expenseEntity.getCreatedAt(), expenseEntity.getUpdatedAt())));
        return expenses;
    }

    public Expense getExpenseById (UUID expenseId) {
        Optional<ExpenseEntity> expenseEntity = this.expenseRepository.findById(expenseId);
        return expenseEntity.map(this::getExpenseFromEntity).orElse(null);
    }

    public Expense addExpense (Expense expense) {
        ExpenseEntity expenseEntity = this.getExpenseEntityFromExpense(expense);
        expenseEntity = this.expenseRepository.save (expenseEntity);
        return this.getExpenseFromEntity(expenseEntity);
    }

    public void deleteExpense (UUID expenseId) {
        this.expenseRepository.deleteById(expenseId);
    }

    // Helper functions
    private Expense getExpenseFromEntity (ExpenseEntity expenseEntity) {
        return new Expense(expenseEntity.getExpenseId(), expenseEntity.getItem(), expenseEntity.getAmount(),
                expenseEntity.getExpenseDate(), expenseEntity.getNotes(), expenseEntity.getCreatedAt(), expenseEntity.getUpdatedAt());
    }

    private ExpenseEntity getExpenseEntityFromExpense (Expense expense) {
        return new ExpenseEntity(expense.getExpenseId(), expense.getItem(), expense.getAmount(), expense.getExpenseDate(), expense.getNotes(),
                expense.getCreatedAt(), expense.getUpdatedAt());
    }
}
