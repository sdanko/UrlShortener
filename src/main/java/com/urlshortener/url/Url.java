package com.urlshortener.url;

import com.urlshortener.core.BaseEntity;
import com.urlshortener.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Url extends BaseEntity{
    private String url;
    @ManyToOne
    private User user;

    public Url(String url) {
        this();
        this.url = url;
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
}
