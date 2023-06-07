package com.example.springdatajpamultiplesinglequeries.bootstrup;


import com.example.springdatajpamultiplesinglequeries.config.ConstantData;
import com.example.springdatajpamultiplesinglequeries.model.Account;
import com.example.springdatajpamultiplesinglequeries.repository.AccountRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class DataLoader {

    @Bean
    public CommandLineRunner loadDataAccount(AccountRepository accountRepository) {
        return (args) -> {
            Faker faker = new Faker();
            for (int i = 1; i <= ConstantData.NUMBER_ACCOUNTS; i++) {
                String username = faker.name().username();
                String email = "";
                if (i % 2 == 0) {
                    email = ConstantData.LIST_OF_EMAILS_TO_SEND.get((i / 2));
                } else {
                    email = faker.internet().emailAddress();
                }
                Account account = Account.builder()
                        .username(username)
                        .email(email)
                        .createdAt(LocalDate.of(2022, Month.JANUARY, 1).plusDays(faker.number().numberBetween(1, 365)))
                        .build();
                accountRepository.save(account);
            }
        };
    }
}
