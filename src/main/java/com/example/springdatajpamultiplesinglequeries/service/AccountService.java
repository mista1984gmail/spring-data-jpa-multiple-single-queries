package com.example.springdatajpamultiplesinglequeries.service;


import java.util.List;

public interface AccountService {

    List<String> getEmailExistsInDBMultipleQueries(List<String> targetEmailList);
    List<String> getEmailExistsInDBSingleQueries(List<String> targetEmailList);
}
