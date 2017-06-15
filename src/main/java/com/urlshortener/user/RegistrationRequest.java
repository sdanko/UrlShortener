package com.urlshortener.user;

import com.fasterxml.jackson.annotation.JsonProperty;

//Model za objekat koji se salje pri registraciji naloga
public class RegistrationRequest {
    private final String AccountId;

    public RegistrationRequest(@JsonProperty("AccountId")String accountId) {
        AccountId = accountId;
    }

    public String getAccountId() {
        return AccountId;
    }
}
