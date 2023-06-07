package com.example.springdatajpamultiplesinglequeries.service;

import com.example.springdatajpamultiplesinglequeries.config.ConstantData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotificationService {
    private final AccountService accountService;

    public void sendEmailMultipleQueries(){
        List<String> targetEmailList = ConstantData.LIST_OF_EMAILS_TO_SEND;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<String> listEmailToSend = accountService.getEmailExistsInDBMultipleQueries(targetEmailList);
        //email send code
        stopWatch.stop();
        System.out.println("Time has passed with to check if an account with this email exists with multiple queries, ms: " + stopWatch.getTime());
        System.out.println("Size of emails list: " + listEmailToSend.size());
    }
    public void sendEmailSingleQueries(){
        List<String> targetEmailList = ConstantData.LIST_OF_EMAILS_TO_SEND;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<String> listEmailToSend = accountService.getEmailExistsInDBSingleQueries(targetEmailList);
        //email send code
        stopWatch.stop();
        System.out.println("Time has passed with to check if an account with this email exists with single queries, ms: " + stopWatch.getTime());
        System.out.println("Size of emails list: " + listEmailToSend.size());
    }

}
