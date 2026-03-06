package com.portfolio.automation.interactions.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.interactions.Actions;

public class HoverOverTarget implements Interaction {

    private final Target target;

    public HoverOverTarget(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Actions actions = new Actions(BrowseTheWeb.as(actor).getDriver());
        actions.moveToElement(target.resolveFor(actor)).perform();
    }

    public static HoverOverTarget on(Target target) {
        return Tasks.instrumented(HoverOverTarget.class, target);
    }
}
