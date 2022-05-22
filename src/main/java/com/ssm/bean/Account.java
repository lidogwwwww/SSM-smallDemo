package com.ssm.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author dog-king
 * @create 2022/5/17
 */
@Component
public class Account implements Serializable {
    static final long serialVersionUID = 423333231212L;
    private Integer id;
    private String name;
    private double balance;

    public Account() {
    }

    public Account(Integer id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
