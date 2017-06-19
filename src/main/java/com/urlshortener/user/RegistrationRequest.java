package com.urlshortener.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//Model za objekat koji se salje pri registraciji naloga
public class RegistrationRequest {
    @NotNull
    @Length(min = 4, message = "The field must be at least 4 characters")
    private String AccountId;

    public RegistrationRequest(@JsonProperty("AccountId")String accountId) {
        AccountId = accountId;
    }

    public String getAccountId() {
        return AccountId;
    }
}
