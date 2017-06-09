package com.urlshortener.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urlshortener.core.BaseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity{
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private String accountId;
    @JsonIgnore
    private String password;

    public User(String accountId) {
        this();
        this.accountId = accountId;
    }

    protected User() {
        super();
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getPassword() {
        return password;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
