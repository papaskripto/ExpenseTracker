package com.papaskripto.expensetracker.web.api;

import com.papaskripto.expensetracker.service.ExpenseService;
import com.papaskripto.expensetracker.web.model.Expense;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/api/expenses")

public class ExpenseApi {

    private final ExpenseService expenseService;

    public ExpenseApi (ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAllExpenses () {
        return this.expenseService.listAllExpenses();
    }

    @GetMapping ("/{expenseId}")
    public Expense getExpense (@PathVariable (name = "expenseId")UUID expenseId) {
        return this.expenseService.getExpenseById(expenseId);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Expense addExpense (@RequestBody Expense expense) {
        return this.expenseService.addExpense (expense);
    }

    @DeleteMapping ("/{id}")
    public void deleteExpense (@PathVariable (name = "expenseId") UUID expenseId, @RequestBody Expense expense) {
        return this.expenseService.deleteExpense (expenseId);
    }
}
