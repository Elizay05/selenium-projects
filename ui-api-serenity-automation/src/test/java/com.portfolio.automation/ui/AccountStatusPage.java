package com.portfolio.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AccountStatusPage {

    private AccountStatusPage() {}

    public static final Target ACCOUNT_CREATED_TITLE = Target.the("account created title")
            .locatedBy("//b[normalize-space()='Account Created!']");

    public static final Target ACCOUNT_DELETED_TITLE = Target.the("account deleted title")
            .locatedBy("//b[normalize-space()='Account Deleted!']");

    public static final Target CONTINUE_BUTTON = Target.the("continue button")
            .locatedBy("//a[@data-qa='continue-button']");

    public static final Target LOGGED_IN_AS = Target.the("logged in as username")
            .locatedBy("//a[contains(.,'Logged in as')]");

    public static final Target DELETE_ACCOUNT_BUTTON = Target.the("delete account button")
            .locatedBy("//a[@href='/delete_account']");
}
