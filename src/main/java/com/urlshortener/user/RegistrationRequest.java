package com.urlshortener.user;


public class RegistrationRequest {
    private final String AccountId;

    public RegistrationRequest(String accountId) {
        AccountId = accountId;
    }

    public String getAccountId() {
        return AccountId;
    }
}
