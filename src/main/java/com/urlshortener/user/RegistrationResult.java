package com.urlshortener.user;

//Model za objekat koji se salje kao rezultat registracije
public class RegistrationResult {
    private final Boolean Success;
    private final String Description;
    private final String Password;


    public RegistrationResult(Boolean success, String description, String password) {
        Success = success;
        Description = description;
        Password = password;
    }

    public Boolean getSuccess() {
        return Success;
    }

    public String getDescription() {
        return Description;
    }

    public String getPassword() {
        return Password;
    }
}
