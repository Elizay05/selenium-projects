package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.pages.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ProceedToCheckout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(CartPage.CART_PRODUCTS, isVisible())
                        .forNoMoreThan(10).seconds(),

                Scroll.to(CartPage.PROCEED_TO_CHECKOUT_BUTTON),

                WaitUntil.the(CartPage.PROCEED_TO_CHECKOUT_BUTTON, isClickable())
                        .forNoMoreThan(10).seconds(),

                SafeClick.on(CartPage.PROCEED_TO_CHECKOUT_BUTTON)
        );
    }

    public static ProceedToCheckout now() {
        return Tasks.instrumented(ProceedToCheckout.class);
    }
}
