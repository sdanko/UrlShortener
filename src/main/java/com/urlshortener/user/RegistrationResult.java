package com.urlshortener.user;

//Model za objekat koji se salje kao rezultat registracije
public class RegistrationResult {
    private Boolean success;
    private String description;
    private String password;


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
