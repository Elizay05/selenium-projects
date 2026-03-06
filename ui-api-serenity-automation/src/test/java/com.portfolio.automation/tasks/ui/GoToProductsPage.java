package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToProductsPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(ProductsPage.PRODUCTS_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
                SafeClick.on(ProductsPage.PRODUCTS_BUTTON)
        );
    }

    public static GoToProductsPage now() {
        return Tasks.instrumented(GoToProductsPage.class);
    }
}
