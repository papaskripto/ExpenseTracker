package com.papaskripto.expensetracker.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {

    private UUID userId;
    private String userEmail;
    private String password;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}