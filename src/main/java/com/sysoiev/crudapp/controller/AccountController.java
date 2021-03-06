package com.sysoiev.crudapp.controller;

import com.sysoiev.crudapp.model.Account;
import com.sysoiev.crudapp.repository.AccountRepository;
import com.sysoiev.crudapp.repository.impl.JavaIOAccountRepositoryImpl;

import java.util.List;

public class AccountController {

    private AccountRepository accountRepository = new JavaIOAccountRepositoryImpl();


    public List<Account> printAll() {
        return accountRepository.getAll();
    }

    public void saveAccount(Account newAccount) {
        accountRepository.save(newAccount);
    }

    public void deleteAccount(long index) {
        accountRepository.deleteById(index);
    }

    public void updateAccount(Account updateAccount) {
        accountRepository.update(updateAccount);

    }

    public Account getValueByIndex(long index) {
        return accountRepository.getById(index);
    }
}