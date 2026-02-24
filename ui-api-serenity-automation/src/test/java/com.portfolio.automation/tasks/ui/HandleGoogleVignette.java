package com.portfolio.automation.tasks.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class HandleGoogleVignette implements Task {

    private final Task retryTask;

    public HandleGoogleVignette(Task retryTask) {
        this.retryTask = retryTask;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String currentUrl = BrowseTheWeb.as(actor)
                .getDriver()
                .getCurrentUrl();

        if (currentUrl.contains("google_vignette")) {

            BrowseTheWeb.as(actor)
                    .getDriver()
                    .navigate()
                    .back();

            actor.attemptsTo(retryTask);
        }
    }

    public static HandleGoogleVignette after(Task retryTask) {
        return new HandleGoogleVignette(retryTask);
    }
}
