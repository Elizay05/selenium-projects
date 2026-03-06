package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.ui.components.FooterComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;

public class ScrollToFooter implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(FooterComponent.SUBSCRIPTION_TITLE)
        );
    }

    public static ScrollToFooter now(){
        return Tasks.instrumented(ScrollToFooter.class);
    }
}
