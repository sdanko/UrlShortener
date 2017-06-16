package com.urlshortener.url;

//Model za objekat koji se salje kao rezultat skracivanja url-a
public class RegistrationUrlResult {
    private final String shortUrl;

    public RegistrationUrlResult(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }
}
