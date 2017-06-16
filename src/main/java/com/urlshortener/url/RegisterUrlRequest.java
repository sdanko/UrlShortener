package com.urlshortener.url;

//Model za objekat koji se salje pri skracivanju url-a
public class RegisterUrlRequest {
    private final String url;
    private final Integer redirectType;

    public RegisterUrlRequest(String url, Integer redirectType) {
        this.url = url;
        this.redirectType = redirectType;
    }

    public String getUrl() {
        return url;
    }

    public Integer getRedirectType() {
        return redirectType;
    }
}
