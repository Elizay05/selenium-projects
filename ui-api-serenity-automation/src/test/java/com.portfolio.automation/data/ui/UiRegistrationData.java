package com.portfolio.automation.data.ui;

public class UiRegistrationData {

    private final String name;
    private final String email;
    private final String password;
    private final String day;
    private final String month;
    private final String year;
    private final String firstName;
    private final String lastName;
    private final String company;
    private final String address1;
    private final String address2;
    private final String country;
    private final String state;
    private final String city;
    private final String zipcode;
    private final String mobileNumber;

    private UiRegistrationData(String name, String email, String password, String day, String month, String year,
                               String firstName, String lastName, String company, String address1, String address2,
                               String country, String state, String city, String zipcode, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.mobileNumber = mobileNumber;
    }

    public static UiRegistrationData defaultData() {
        long timestamp = System.currentTimeMillis();
        return new UiRegistrationData(
                "QA User",
                "qa.user." + timestamp + "@mail.com",
                "Test1234!",
                "10",
                "10",
                "2000",
                "QA",
                "User",
                "Automation Co",
                "Street 123",
                "Apartment 5",
                "Canada",
                "Ontario",
                "Toronto",
                "A1B2C3",
                "1234567890"
        );
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getDay() { return day; }
    public String getMonth() { return month; }
    public String getYear() { return year; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCompany() { return company; }
    public String getAddress1() { return address1; }
    public String getAddress2() { return address2; }
    public String getCountry() { return country; }
    public String getState() { return state; }
    public String getCity() { return city; }
    public String getZipcode() { return zipcode; }
    public String getMobileNumber() { return mobileNumber; }
}
