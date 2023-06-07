package com.example.springdatajpamultiplesinglequeries.repository;


import com.example.springdatajpamultiplesinglequeries.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByEmail(String email);

    @Query("select a.email from Account a where a.email IN(:emails)")
    List<String> emailExists(@Param("emails") List<String> emails);
}
