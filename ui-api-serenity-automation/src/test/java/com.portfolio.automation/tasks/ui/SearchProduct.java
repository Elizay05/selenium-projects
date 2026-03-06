package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchProduct implements Task {

    private final String productName;

    public SearchProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(ProductsPage.SEARCH_INPUT, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(productName).into(ProductsPage.SEARCH_INPUT),
                SafeClick.on(ProductsPage.SEARCH_BUTTON)
        );
    }

    public static SearchProduct called(String productName) {
        return Tasks.instrumented(SearchProduct.class, productName);
    }
}
