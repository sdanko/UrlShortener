package com.urlshortener.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urlshortener.core.BaseEntity;
import com.urlshortener.url.Url;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends BaseEntity{
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private String accountId;
    @JsonIgnore
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Url> urls;

    public User(String accountId, String password) {
        this();
        this.accountId = accountId;
        setPassword(password);
    }

    protected User() {
        super();
        urls = new ArrayList<>();
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

    public List<Url> getUrls() {
        return urls;
    }

    public void addUrl(Url url) {
        url.setUser(this);
        urls.add(url);
    }
}
