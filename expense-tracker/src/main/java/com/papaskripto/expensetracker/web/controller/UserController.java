package com.papaskripto.expensetracker.web.controller;

import com.papaskripto.expensetracker.data.entity.UserEntity;
import com.papaskripto.expensetracker.data.repository.UserRepository;
import com.papaskripto.expensetracker.web.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping ("/users")

public class UserController {

    private final UserRepository userRepository;

    public UserController (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String getUsersPage (Model model) {
        List<UserEntity> userEntities = this.userRepository.findAll();
        List<User> users = new ArrayList<>(userEntities.size());
        userEntities.forEach(userEntity -> users.add (new User(userEntity.getUserId(), userEntity.getUserEmail(), userEntity.getPassword(),
                userEntity.getUsername(), userEntity.getCreatedAt(), userEntity.getUpdatedAt())));
        model.addAttribute("users", users);
        return "users";
    }
}
