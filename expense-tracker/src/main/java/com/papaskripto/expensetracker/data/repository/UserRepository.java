package com.papaskripto.expensetracker.data.repository;

import com.papaskripto.expensetracker.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
