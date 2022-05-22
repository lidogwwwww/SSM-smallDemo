package com.ssm.serviceImpl;

import com.ssm.bean.Account;
import com.ssm.mapper.accountMapper;
import com.ssm.service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

/**
 * @author dog-king
 * @create 2022/5/17
 */
@Service("accountService")
public class accountServiceImpl implements accountService {
    @Autowired
    com.ssm.mapper.accountMapper accountMapper;
    @Override
    public List<Account> getAllAccount() {
        return  accountMapper.getAllAccount();
    }

    @Override
    public void addAccount(Account account) {
       accountMapper.addAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        accountMapper.deleteAccount(id);
    }

    @Override
    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
    }
}
