package com.portfolio.automation.models.ui;

public class UiLoginData {
    private final String email;
    private final String password;

    public UiLoginData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
