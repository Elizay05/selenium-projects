package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.AccountInfoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CreateAccount implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SafeClick.on(AccountInfoPage.CREATE_ACCOUNT_BUTTON)
        );
    }

    public static CreateAccount now() {
        return Tasks.instrumented(CreateAccount.class);
    }
}
