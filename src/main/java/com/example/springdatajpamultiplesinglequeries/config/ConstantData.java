package com.example.springdatajpamultiplesinglequeries.config;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class ConstantData {

    public final static int NUMBER_ACCOUNTS = 10_000;
    public final static int NUMBER_OF_EMAILS_TO_SEND = (NUMBER_ACCOUNTS / 2) + 1;
    public final static List<String> LIST_OF_EMAILS_TO_SEND = createListOfEmails();

    static List<String> createListOfEmails() {
        Faker faker = new Faker();
        List<String> emailsToSend = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_EMAILS_TO_SEND; i++) {
            emailsToSend.add(faker.internet().emailAddress());
        }
        return emailsToSend;
    }
}
