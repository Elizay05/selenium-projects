package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ContinueShopping implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SafeClick.on(ProductsPage.CONTINUE_SHOPPING_BUTTON)
        );
    }

    public static ContinueShopping now() {
        return Tasks.instrumented(ContinueShopping.class);
    }
}
