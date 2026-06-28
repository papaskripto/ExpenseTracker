package com.papaskripto.expensetracker.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/expenses")

public class ExpenseController {

    @GetMapping
    public String getExpensesPage () {
        return "expenses";
    }
}
