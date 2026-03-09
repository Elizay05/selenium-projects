package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.pages.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CartProductCount implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return CartPage.CART_PRODUCTS.resolveAllFor(actor).size();
    }

    public static CartProductCount value() {
        return new CartProductCount();
    }
}