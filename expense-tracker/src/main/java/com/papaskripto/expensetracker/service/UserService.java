package com.papaskripto.expensetracker.service;

import com.papaskripto.expensetracker.data.entity.ExpenseEntity;
import com.papaskripto.expensetracker.data.entity.UserEntity;
import com.papaskripto.expensetracker.data.repository.UserRepository;
import com.papaskripto.expensetracker.web.model.Expense;
import com.papaskripto.expensetracker.web.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class UserService {

    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listUsers () {
        List<UserEntity> userEntities = this.userRepository.findAll();
        List<User> users = new ArrayList<>(userEntities.size());
        userEntities.forEach(userEntity -> users.add(new User(userEntity.getUserId(), userEntity.getUserEmail(),
                userEntity.getPassword(), userEntity.getUsername(), userEntity.getCreatedAt(), userEntity.getUpdatedAt())));
        return users;
    }

    public User getUserById (UUID userId) {
        Optional<UserEntity> userEntity = this.userRepository.findById(userId);
        return userEntity.map(this::getUserFromEntity).orElse(null);
    }

    public User addUser (User user) {
        UserEntity userEntity = this.getUserEntityFromUser(user);
        userEntity = this.userRepository.save (userEntity);
        return this.getUserFromEntity(userEntity);
    }

    public void deleteUser (UUID userId) {
        this.userRepository.deleteById(userId);
    }

    // Helper functions
    private User getUserFromEntity (UserEntity userEntity) {
        return new User(userEntity.getUserId(), userEntity.getUserEmail(), userEntity.getPassword(),
                userEntity.getUsername(), userEntity.getCreatedAt(), userEntity.getUpdatedAt());
    }

    private UserEntity getUserEntityFromUser (User user) {
        return new UserEntity(user.getUserId(), user.getUserEmail(), user.getPassword(),
                user.getUsername(), user.getCreatedAt(), user.getUpdatedAt());
    }
}
