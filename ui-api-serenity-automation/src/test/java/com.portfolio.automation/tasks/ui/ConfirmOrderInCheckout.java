package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class ConfirmOrderInCheckout implements Task {

    private final String comment;

    public ConfirmOrderInCheckout(String comment) {
        this.comment = comment;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(CheckoutPage.COMMENT_BOX),
                Enter.theValue(comment).into(CheckoutPage.COMMENT_BOX),
                SafeClick.on(CheckoutPage.PLACE_ORDER_BUTTON)
        );
    }

    public static ConfirmOrderInCheckout withComment(String comment) {
        return Tasks.instrumented(ConfirmOrderInCheckout.class, comment);
    }
}
