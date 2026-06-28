package com.papaskripto.expensetracker.web.controller;

import com.papaskripto.expensetracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/expenses")

public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController (ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public String getExpensesPage (Model model) {
        model.addAttribute("expenses", this.expenseService.listAllExpenses());
        return "expenses";
    }
}
