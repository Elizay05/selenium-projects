package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.questions.ui.SearchedProductNames;
import com.portfolio.automation.ui.pages.ProductsPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

public class AddSearchedProductsToCart implements Task {

    public static AddSearchedProductsToCart now() {
        return Tasks.instrumented(AddSearchedProductsToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> products = SearchedProductNames.value().answeredBy(actor);
        actor.attemptsTo(
                ManageCart.addProducts(products)
        );
    }
}
