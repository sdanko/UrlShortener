package com.urlshortener.url;

//Model za objekat koji se salje kao rezultat skracivanja url-a
public class RegisterUrlResult {
    private final String shortUrl;

    public RegisterUrlResult(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }
}
