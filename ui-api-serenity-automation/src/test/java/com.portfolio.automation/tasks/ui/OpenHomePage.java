package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.OpenUrl;

public class OpenHomePage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(OpenUrl.of(HomePage.URL));
    }

    public static OpenHomePage now() {
        return new OpenHomePage();
    }
}
