package com.papaskripto.expensetracker.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name = "USERS")

public class UserEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)

    @Column (name = "USER_ID")
    private UUID userId;

    @Column (name = "USER_EMAIL")
    private String userEmail;

    @Column (name = "PASSWORD")
    private String password;

    @Column (name = "USERNAME")
    private String username;

    @Column (name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column (name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}