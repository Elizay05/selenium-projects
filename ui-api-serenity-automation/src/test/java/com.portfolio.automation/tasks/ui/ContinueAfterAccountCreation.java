package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.pages.AccountStatusPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ContinueAfterAccountCreation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AccountStatusPage.ACCOUNT_CREATED_TITLE, isVisible()).forNoMoreThan(5).seconds(),
                Scroll.to(AccountStatusPage.CONTINUE_BUTTON),
                SafeClick.on(AccountStatusPage.CONTINUE_BUTTON)
        );
    }

    public static ContinueAfterAccountCreation now() {
        return Tasks.instrumented(ContinueAfterAccountCreation.class);
    }
}
