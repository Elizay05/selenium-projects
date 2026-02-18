package com.portfolio.automation.data;

import com.portfolio.automation.models.CreateUserRequest;

public class UserTestDataBuilder {

    private String name = "Test User";
    private String email = "user" + System.currentTimeMillis() + "@mail.com";
    private String password = "test123";
    private String title = "Mrs";
    private String birthDate = "10";
    private String birthMonth = "10";
    private String birthYear = "2000";
    private String firstname = "Test";
    private String lastname = "User";
    private String company = "QA Company";
    private String address1 = "Street 123";
    private String country = "Colombia";
    private String zipcode = "050001";
    private String state = "Antioquia";
    private String city = "Medellin";
    private String mobileNumber = "3001234567";

    private UserTestDataBuilder() {}

    public static UserTestDataBuilder aUser() {
        return new UserTestDataBuilder();
    }

    // =========================
    // Métodos dinámicos (fluency)
    // =========================

    public UserTestDataBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserTestDataBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserTestDataBuilder withoutEmail() {
        this.email = "";
        return this;
    }

    public UserTestDataBuilder withoutPassword() {
        this.password = "";
        return this;
    }

    public UserTestDataBuilder withInvalidEmail() {
        this.email = "invalid-email";
        return this;
    }

    public UserTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserTestDataBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    // =========================
    // BUILD FINAL
    // =========================

    public CreateUserRequest build() {
        return CreateUserRequest.builder()
                .name(name)
                .email(email)
                .password(password)
                .title(title)
                .birth_date(birthDate)
                .birth_month(birthMonth)
                .birth_year(birthYear)
                .firstname(firstname)
                .lastname(lastname)
                .company(company)
                .address1(address1)
                .country(country)
                .zipcode(zipcode)
                .state(state)
                .city(city)
                .mobile_number(mobileNumber)
                .build();
    }
}
