package com.urlshortener.user;

//Model za objekat koji se salje pri registraciji naloga
public class RegistrationRequest {
    private final String AccountId;

    public RegistrationRequest(String accountId) {
        AccountId = accountId;
    }

    public String getAccountId() {
        return AccountId;
    }
}
