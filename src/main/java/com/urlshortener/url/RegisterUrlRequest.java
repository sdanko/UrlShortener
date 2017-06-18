package com.urlshortener.url;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

//Model za objekat koji se salje pri skracivanju url-a
public class RegisterUrlRequest {
    @NotNull
    private  String url;
    private Integer redirectType = 302;

    public RegisterUrlRequest(@JsonProperty("url")String url, @JsonProperty("redirectType")Integer redirectType) {
        this.url = url;
        this.redirectType = redirectType;
    }

    public String getUrl() {
        return url;
    }

    public Integer getRedirectType() {
        return redirectType;
    }
}
