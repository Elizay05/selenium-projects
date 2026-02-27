package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.AccountStatusPage;
import net.serenitybdd.screenplay.Question;

public class TheUser {

    public static Question<Boolean> isLoggedIn() {
        return actor ->
                AccountStatusPage.LOGGED_IN_AS
                        .resolveFor(actor)
                        .isVisible();
    }
}
