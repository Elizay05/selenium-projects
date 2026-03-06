package com.portfolio.automation.ui.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SignupLoginPage {

    private SignupLoginPage() {}

    public static final Target LOGIN_EMAIL = Target.the("login email")
            .locatedBy("//input[@data-qa='login-email']");

    public static final Target LOGIN_PASSWORD = Target.the("login password")
            .locatedBy("//input[@data-qa='login-password']");

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .locatedBy("//button[@data-qa='login-button']");

    public static final Target LOGIN_TITLE = Target.the("login to your account title")
            .locatedBy("//h2[normalize-space()='Login to your account']");

    public static final Target LOGIN_ERROR_MESSAGE =
            Target.the("login error message")
                    .located(By.xpath("//*[contains(text(),'Your email or password is incorrect!')]"));

    public static final Target SIGNUP_NAME = Target.the("signup name")
            .locatedBy("//input[@data-qa='signup-name']");

    public static final Target SIGNUP_EMAIL = Target.the("signup email")
            .locatedBy("//input[@data-qa='signup-email']");

    public static final Target SIGNUP_BUTTON = Target.the("signup button")
            .locatedBy("//button[@data-qa='signup-button']");

    public static final Target NEW_USER_SIGNUP_TITLE = Target.the("new user signup title")
            .locatedBy("//h2[normalize-space()='New User Signup!']");

    public static final Target SIGNUP_EXISTING_EMAIL_ERROR =
            Target.the("existing email error message")
                    .located(By.xpath("//*[contains(text(),'Email Address already exist!')]"));
}
