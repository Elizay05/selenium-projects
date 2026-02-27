package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.AccountStatusPage;
import net.serenitybdd.screenplay.Question;

public class TheAccount {

    public static Question<Boolean> wasCreated() {
        return actor ->
                AccountStatusPage.ACCOUNT_CREATED_TITLE
                        .resolveFor(actor)
                        .isVisible();
    }

    public static Question<Boolean> wasDeleted() {
        return actor ->
                AccountStatusPage.ACCOUNT_DELETED_TITLE
                        .resolveFor(actor)
                        .isVisible();
    }
}
