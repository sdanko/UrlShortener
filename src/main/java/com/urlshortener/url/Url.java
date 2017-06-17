package com.urlshortener.url;

import com.urlshortener.core.BaseEntity;
import com.urlshortener.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Url extends BaseEntity{
    private String url;
    private Integer redirectType;
    private Integer redirects;
    /*@ManyToOne
    private User user;*/
    private String accountId;

    public Url(String url, Integer redirectType, Integer redirects, String accountId) {
        this();
        this.url = url;
        this.redirectType = redirectType;
        this.redirects = redirects;
        this.accountId = accountId;
}

    protected Url() { super(); }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(Integer redirectType) {
        this.redirectType = redirectType;
    }

    public Integer getRedirects() {
        return redirects;
    }

    public void setRedirects(Integer redirects) {
        this.redirects = redirects;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
