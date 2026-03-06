package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.components.FooterComponent;
import com.portfolio.automation.ui.pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SubscribeToNewsletter implements Task {

    private final String email;

    public SubscribeToNewsletter(String email) {
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(FooterComponent.SUBSCRIPTION_EMAIL_INPUT, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(email).into(FooterComponent.SUBSCRIPTION_EMAIL_INPUT),
                SafeClick.on(FooterComponent.SUBSCRIPTION_BUTTON)
        );
    }

    public static SubscribeToNewsletter withEmail(String email){
        return Tasks.instrumented(SubscribeToNewsletter.class, email);
    }
}
