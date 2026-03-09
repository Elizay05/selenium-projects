package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ClickRegisterLogin implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SafeClick.on(CheckoutPage.REGISTER_LOGIN_BUTTON)
        );
    }

    public static ClickRegisterLogin now() {
        return Tasks.instrumented(ClickRegisterLogin.class);
    }
}
