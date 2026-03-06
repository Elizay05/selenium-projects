package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.pages.AccountStatusPage;
import com.portfolio.automation.ui.pages.SignupLoginPage;
import net.serenitybdd.screenplay.Question;

public class AccountStatus {

    public static Question<Boolean> isCreated() {
        return actor ->
                AccountStatusPage.ACCOUNT_CREATED_TITLE
                        .resolveFor(actor)
                        .isVisible();
    }

    public static Question<Boolean> isDeleted() {
        return actor ->
                AccountStatusPage.ACCOUNT_DELETED_TITLE
                        .resolveFor(actor)
                        .isVisible();
    }

    public static Question<Boolean> isLoggedIn() {
        return actor ->
                AccountStatusPage.LOGGED_IN_AS
                        .resolveFor(actor)
                        .isVisible();
    }

    public static Question<Boolean> loginErrorIsVisible() {
        return actor ->
                SignupLoginPage.LOGIN_ERROR_MESSAGE
                        .resolveFor(actor)
                        .isVisible();
    }
}
