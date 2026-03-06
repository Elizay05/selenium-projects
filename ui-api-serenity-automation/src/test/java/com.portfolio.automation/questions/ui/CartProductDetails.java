package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.components.CartComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.portfolio.automation.utils.PriceUtils.extractPrice;

public class CartProductDetails implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        var prices = CartComponent.PRODUCT_PRICE.resolveAllFor(actor);
        var quantities = CartComponent.PRODUCT_QUANTITY.resolveAllFor(actor);
        var totals = CartComponent.PRODUCT_TOTAL.resolveAllFor(actor);

        for (int i = 0; i < prices.size(); i++) {

            int price = extractPrice(prices.get(i).getText());
            int quantity = Integer.parseInt(quantities.get(i).getText());
            int total = extractPrice(totals.get(i).getText());

            if (price * quantity != total) {
                return false;
            }
        }

        return true;
    }

    public static CartProductDetails areCorrect() {
        return new CartProductDetails();
    }
}
