package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.components.CartComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CartProducts implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return CartComponent.CART_PRODUCTS.resolveAllFor(actor).size() == 2;
    }

    public static CartProducts areVisible() {
        return new CartProducts();
    }
}
