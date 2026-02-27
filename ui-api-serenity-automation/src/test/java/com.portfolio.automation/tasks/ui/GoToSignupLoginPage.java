package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToSignupLoginPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.SIGNUP_LOGIN_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                SafeClick.on(HomePage.SIGNUP_LOGIN_BUTTON)
        );
    }

    public static GoToSignupLoginPage fromHome() {
        return Tasks.instrumented(GoToSignupLoginPage.class);
    }
}
