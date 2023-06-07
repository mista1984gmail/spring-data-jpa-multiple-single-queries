package com.example.springdatajpamultiplesinglequeries.service;


import com.example.springdatajpamultiplesinglequeries.model.Account;
import com.example.springdatajpamultiplesinglequeries.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Override
    public List<String> getEmailExistsInDBMultipleQueries(List<String> targetEmailList) {
        return  targetEmailList.stream()
                .filter(accountRepository::existsByEmail)
                .toList();
    }
    @Override
    public List<String> getEmailExistsInDBSingleQueries(List<String> targetEmailList) {
        return accountRepository.emailExists(targetEmailList);
    }


}
