package com.urlshortener.user;

//Model za objekat koji se salje kao rezultat registracije
public class RegistrationResult {
    private final Boolean success;
    private final String description;
    private final String password;


    public RegistrationResult(Boolean success, String description, String password) {
        this.success = success;
        this.description = description;
        this.password = password;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getDescription() {
        return description;
    }

    public String getPassword() {
        return password;
    }
}
