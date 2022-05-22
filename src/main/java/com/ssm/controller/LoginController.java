package com.ssm.controller;

import com.ssm.bean.User;
import com.ssm.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author dog-king
 * @create 2022/5/18
 */
@Controller
public class LoginController {
    @Autowired
    private loginService loginService;
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String Login(User user,HttpSession session){
        int result=loginService.Login(user);
        if(result>0)
        {
            session.setAttribute("loginUser",user.getUsername());
            return "redirect:/account";
        }
        else
        {
            return "redirect:/";
        }
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
   public String Logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
