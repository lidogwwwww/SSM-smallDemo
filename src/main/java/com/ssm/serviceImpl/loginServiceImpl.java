package com.ssm.serviceImpl;

import com.ssm.bean.User;
import com.ssm.mapper.loginMapper;
import com.ssm.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dog-king
 * @create 2022/5/18
 */
@Service
public class loginServiceImpl implements loginService {

    @Autowired
   private loginMapper loginMapper;
    @Override
    public int Login(User user) {
        return loginMapper.Login(user);
    }
}
