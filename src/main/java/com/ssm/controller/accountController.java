package com.ssm.controller;

import com.ssm.bean.Account;
import com.ssm.bean.User;
import com.ssm.service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author dog-king
 * @create 2022/5/17
 */
@Controller
public class accountController {
    @Autowired
    private accountService accountService;
    private boolean getSession( HttpSession session){
        String sessionName= (String) session.getAttribute("loginUser");
        return sessionName==null;
    }

    @RequestMapping(value = "/account",method= RequestMethod.GET)
    public  String getAllAccount(Model model,HttpSession session){
        if(getSession(session)){
           return  "redirect:/";
        }else {
            List<Account> list = accountService.getAllAccount();
            model.addAttribute("allList", list);
            return "allAccount";
        }
    }
    @RequestMapping(value = "/account/{id}",method = RequestMethod.DELETE)
    public String deleteAccount(@PathVariable("id")Integer id,HttpSession session){
        if(getSession(session)){
            return  "redirect:/";
        }else {
            accountService.deleteAccount(id);
            return "redirect:/account";
        }
    }
    @RequestMapping(value = "/account",method = RequestMethod.POST)
    public String addAccount(Account account,Model model,HttpSession session)
    {
        if(getSession(session)){
            return  "redirect:/";
        }else {
        accountService.addAccount(account);
        model.addAttribute("message","添加成功");
        return "redirect:/account";
        }
    }
    @RequestMapping(value = "/account/{id}/{name}/{balance}",method = RequestMethod.GET)
    public String accountUpdateForward(@PathVariable("id") Integer id,@PathVariable("name") String name ,@PathVariable("balance") double balance,Model model,HttpSession session){
       if(getSession(session))
       {
           return  "redirect:/";
       }else {
           Account account = new Account(id, name, balance);
           model.addAttribute("message", account);
           return "updateAccount";
       }
    }
    @RequestMapping(value = "/account",method = RequestMethod.PUT)
    public String accountUpdate(Account account){
        accountService.updateAccount(account);
        return "redirect:/account";
    }
}
