package com.example.springdatajpamultiplesinglequeries.web;

import com.example.springdatajpamultiplesinglequeries.model.Account;
import com.example.springdatajpamultiplesinglequeries.service.AccountService;
import com.example.springdatajpamultiplesinglequeries.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final NotificationService notificationService;

    @GetMapping("/emailSendMultipleQueries")
    @ResponseStatus(HttpStatus.OK)
    public void emailSendMultipleQueries() {
        log.info("Send emails with multiple queries");
        notificationService.sendEmailMultipleQueries();
    }
    @GetMapping("/emailSendSingleQueries")
    @ResponseStatus(HttpStatus.OK)
    public void emailSendSingleQueries() {
        log.info("Send emails with single queries");
        notificationService.sendEmailSingleQueries();
    }

}
