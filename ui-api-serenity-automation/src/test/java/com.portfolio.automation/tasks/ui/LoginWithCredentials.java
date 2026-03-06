package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.pages.SignupLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginWithCredentials implements Task {

    private final String email;
    private final String password;

    public LoginWithCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SignupLoginPage.LOGIN_EMAIL, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(email).into(SignupLoginPage.LOGIN_EMAIL),
                Enter.theValue(password).into(SignupLoginPage.LOGIN_PASSWORD),
                SafeClick.on(SignupLoginPage.LOGIN_BUTTON)
        );
    }

    public static LoginWithCredentials using(String email, String password) {
        return Tasks.instrumented(LoginWithCredentials.class, email, password);
    }
}
