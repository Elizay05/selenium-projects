package com.portfolio.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AccountInfoPage {

    private AccountInfoPage() {}

    public static final Target ENTER_ACCOUNT_INFORMATION_TITLE = Target.the("enter account information title")
            .locatedBy("//b[normalize-space()='Enter Account Information']");

    public static final Target TITLE_MRS = Target.the("title mrs")
            .locatedBy("//input[@id='id_gender2']");

    public static final Target PASSWORD = Target.the("password field")
            .locatedBy("//input[@id='password']");

    public static final Target DAY = Target.the("day dropdown")
            .locatedBy("//select[@id='days']");

    public static final Target MONTH = Target.the("month dropdown")
            .locatedBy("//select[@id='months']");

    public static final Target YEAR = Target.the("year dropdown")
            .locatedBy("//select[@id='years']");

    public static final Target NEWSLETTER = Target.the("newsletter checkbox")
            .locatedBy("//input[@id='newsletter']");

    public static final Target OFFERS = Target.the("offers checkbox")
            .locatedBy("//input[@id='optin']");

    public static final Target FIRST_NAME = Target.the("first name")
            .locatedBy("//input[@id='first_name']");

    public static final Target LAST_NAME = Target.the("last name")
            .locatedBy("//input[@id='last_name']");

    public static final Target COMPANY = Target.the("company")
            .locatedBy("//input[@id='company']");

    public static final Target ADDRESS1 = Target.the("address1")
            .locatedBy("//input[@id='address1']");

    public static final Target ADDRESS2 = Target.the("address2")
            .locatedBy("//input[@id='address2']");

    public static final Target COUNTRY = Target.the("country")
            .locatedBy("//select[@id='country']");

    public static final Target STATE = Target.the("state")
            .locatedBy("//input[@id='state']");

    public static final Target CITY = Target.the("city")
            .locatedBy("//input[@id='city']");

    public static final Target ZIPCODE = Target.the("zipcode")
            .locatedBy("//input[@id='zipcode']");

    public static final Target MOBILE = Target.the("mobile number")
            .locatedBy("//input[@id='mobile_number']");

    public static final Target CREATE_ACCOUNT_BUTTON = Target.the("create account button")
            .locatedBy("//button[@data-qa='create-account']");
}
