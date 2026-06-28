package com.papaskripto.expensetracker.web.controller;

import com.papaskripto.expensetracker.data.entity.ExpenseEntity;
import com.papaskripto.expensetracker.data.repository.ExpenseRepository;
import com.papaskripto.expensetracker.web.model.Expense;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping ("/expenses")

public class ExpenseController {

    private final ExpenseRepository expenseRepository;

    public ExpenseController (ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping
    public String getExpensesPage (Model model) {
        List<ExpenseEntity> expenseEntities = this.expenseRepository.findAll();
        List<Expense> expenses = new ArrayList<>(expenseEntities.size ());
        expenseEntities.forEach(expenseEntity -> expenses.add (new Expense(expenseEntity.getExpenseId(), expenseEntity.getItem(), expenseEntity.getAmount(),
                expenseEntity.getExpenseDate(), expenseEntity.getNotes(), expenseEntity.getCreatedAt(), expenseEntity.getUpdatedAt())));
        model.addAttribute("expenses", expenses);
        return "expenses";
    }
}
