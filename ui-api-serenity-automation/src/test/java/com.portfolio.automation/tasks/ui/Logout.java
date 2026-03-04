package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.AccountStatusPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Logout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AccountStatusPage.LOGOUT_BUTTON, isVisible())
                        .forNoMoreThan(5).seconds(),
                SafeClick.on(AccountStatusPage.LOGOUT_BUTTON)
        );
    }

    public static Logout now() {
        return Tasks.instrumented(Logout.class);
    }
}