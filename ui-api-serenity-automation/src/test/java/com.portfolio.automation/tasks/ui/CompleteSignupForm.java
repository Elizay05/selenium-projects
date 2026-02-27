package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.data.ui.UiRegistrationData;
import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.SignupLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteSignupForm implements Task {

    private final UiRegistrationData data;

    public CompleteSignupForm(UiRegistrationData data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SignupLoginPage.SIGNUP_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(data.getName()).into(SignupLoginPage.SIGNUP_NAME),
                Enter.theValue(data.getEmail()).into(SignupLoginPage.SIGNUP_EMAIL),
                SafeClick.on(SignupLoginPage.SIGNUP_BUTTON)
        );
    }

    public static CompleteSignupForm with(UiRegistrationData data) {
        return Tasks.instrumented(CompleteSignupForm.class, data);
    }
}
