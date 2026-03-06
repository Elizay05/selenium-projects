package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;

public class OpenFirstProduct implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ProductsPage.FIRST_VIEW_PRODUCT),
                SafeClick.on(ProductsPage.FIRST_VIEW_PRODUCT)
        );
    }

    public static OpenFirstProduct now() {
        return Tasks.instrumented(OpenFirstProduct.class);
    }
}
