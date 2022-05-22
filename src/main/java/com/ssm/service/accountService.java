package com.ssm.service;

import com.ssm.bean.Account;

import java.util.List;

/**
 * @author dog-king
 * @create 2022/5/17
 */
public interface accountService {

    List<Account> getAllAccount();

    void addAccount(Account account);

    void deleteAccount(Integer id);

    void updateAccount(Account account);
}
