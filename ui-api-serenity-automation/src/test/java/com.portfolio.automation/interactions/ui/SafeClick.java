package com.portfolio.automation.interactions.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SafeClick implements Interaction {
    private final Target target;

    public SafeClick(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(target, isVisible())
                        .forNoMoreThan(5).seconds(),
                Click.on(target)
        );

        String currentUrl = BrowseTheWeb.as(actor)
                .getDriver()
                .getCurrentUrl();

        if (currentUrl.contains("google_vignette")) {

            BrowseTheWeb.as(actor)
                    .getDriver()
                    .navigate()
                    .back();

            actor.attemptsTo(
                    WaitUntil.the(target, isVisible())
                            .forNoMoreThan(5).seconds(),
                    Click.on(target)
            );
        }
    }

    public static SafeClick on(Target target) {
        return Tasks.instrumented(SafeClick.class, target);
    }
}
