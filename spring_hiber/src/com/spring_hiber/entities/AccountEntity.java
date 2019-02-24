package com.spring_hiber.entities;

import javax.persistence.*;
import java.util.Objects;


public class AccountEntity {
    private int id;
    private String username;
    private Integer balance;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, balance);
    }
}
