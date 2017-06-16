package com.urlshortener.url;

import com.urlshortener.core.BaseEntity;
import com.urlshortener.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Url extends BaseEntity{
    private String url;
    private Integer redirectType;
    @ManyToOne
    private User user;

    public Url(String url, Integer redirectType) {
        this();
        this.url = url;
        this.redirectType = redirectType;
}

    protected Url() { super(); }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(Integer redirectType) {
        this.redirectType = redirectType;
    }
}
