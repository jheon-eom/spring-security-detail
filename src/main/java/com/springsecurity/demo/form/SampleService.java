package com.springsecurity.demo.form;

import com.springsecurity.demo.account.Account;
import com.springsecurity.demo.account.AccountContext;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public void dashboard() {
        Account account = AccountContext.getAccount();
        System.out.println("=====================");
        System.out.println(account.getUsername());
    }
}
