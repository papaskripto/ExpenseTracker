package com.papaskripto.expensetracker.web.api;

import com.papaskripto.expensetracker.service.UserService;
import com.papaskripto.expensetracker.web.model.Expense;
import com.papaskripto.expensetracker.web.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/api/users")

public class UserApi {

    private final UserService userService;

    public UserApi (UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers () {
        return userService.listUsers();
    }

    @GetMapping ("/{userId}")
    public User getUser (@PathVariable(name = "userId") UUID userId) {
        return this.userService.getUserById(userId);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public User addUser (@RequestBody User user) {
        return this.userService.addUser (user);
    }

    @DeleteMapping ("/{userId}")
    public void deleteUser (@PathVariable (name = "userId") UUID userId, @RequestBody User user) {
        this.userService.deleteUser (userId);
    }
}
