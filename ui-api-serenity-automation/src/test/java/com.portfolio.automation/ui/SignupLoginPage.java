package com.portfolio.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class SignupLoginPage {

    private SignupLoginPage() {}

    public static final Target SIGNUP_NAME = Target.the("signup name")
            .locatedBy("//input[@data-qa='signup-name']");

    public static final Target SIGNUP_EMAIL = Target.the("signup email")
            .locatedBy("//input[@data-qa='signup-email']");

    public static final Target SIGNUP_BUTTON = Target.the("signup button")
            .locatedBy("//button[@data-qa='signup-button']");

    public static final Target NEW_USER_SIGNUP_TITLE = Target.the("new user signup title")
            .locatedBy("//h2[normalize-space()='New User Signup!']");
}
