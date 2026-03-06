package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductsList implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return ProductsPage.PRODUCTS_LIST.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> isVisible(){
        return new ProductsList();
    }
}
