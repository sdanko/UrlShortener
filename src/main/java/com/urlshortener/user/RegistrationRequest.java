package com.urlshortener.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

//Model za objekat koji se salje pri registraciji naloga
public class RegistrationRequest {
    @NotNull
    private String AccountId;

    public RegistrationRequest(@JsonProperty("AccountId")String accountId) {
        AccountId = accountId;
    }

    public String getAccountId() {
        return AccountId;
    }
}
