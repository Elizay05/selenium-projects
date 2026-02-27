package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenHomePage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(HomePage.URL));
    }

    public static OpenHomePage now() {
        return Tasks.instrumented(OpenHomePage.class);
    }
}
