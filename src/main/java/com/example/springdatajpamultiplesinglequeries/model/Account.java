package com.example.springdatajpamultiplesinglequeries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="username",
            nullable = false)
    private String username;
    @Column(name="email",
            nullable = false)
    private String email;
    @Column(name="created_at",
            nullable = false)
    private LocalDate createdAt;

    public Account(String username, String email, LocalDate createdAt) {
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
    }
}
