package com.portfolio.automation.questions.ui;

import com.portfolio.automation.models.ui.UiExpectedProduct;
import com.portfolio.automation.ui.pages.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartProductDetails implements Question<Boolean> {

    private final List<UiExpectedProduct> expectedProducts;

    public CartProductDetails(List<UiExpectedProduct> expectedProducts) {
        this.expectedProducts = expectedProducts;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        var names = CartPage.PRODUCT_NAME.resolveAllFor(actor);
        var prices = CartPage.PRODUCT_PRICE.resolveAllFor(actor);
        var quantities = CartPage.PRODUCT_QUANTITY.resolveAllFor(actor);
        var totals = CartPage.PRODUCT_TOTAL.resolveAllFor(actor);

        Map<String, UiExpectedProduct> expectedMap = new HashMap<>();

        for (UiExpectedProduct product : expectedProducts) {
            expectedMap.put(product.getProduct(), product);
        }

        for (int i = 0; i < names.size(); i++) {

            String productName = names.get(i).getText();

            UiExpectedProduct expected = expectedMap.get(productName);

            if (expected == null) {
                throw new AssertionError("Unexpected product in cart: " + productName);
            }

            int actualPrice = extractPrice(prices.get(i).getText());
            int actualQty = Integer.parseInt(quantities.get(i).getText());
            int actualTotal = extractPrice(totals.get(i).getText());

            if (actualPrice != expected.getPrice()) {
                throw new AssertionError(
                        "Price mismatch for product '" + productName +
                                "'. Expected: " + expected.getPrice() +
                                " but was: " + actualPrice
                );
            }

            if (actualQty != expected.getQty()) {
                throw new AssertionError(
                        "Quantity mismatch for product '" + productName +
                                "'. Expected: " + expected.getQty() +
                                " but was: " + actualQty
                );
            }

            if (actualTotal != expected.getTotal()) {
                throw new AssertionError(
                        "Total mismatch for product '" + productName +
                                "'. Expected: " + expected.getTotal() +
                                " but was: " + actualTotal
                );
            }
        }

        return true;
    }

    public static CartProductDetails areCorrect(List<UiExpectedProduct> expectedProducts) {
        return new CartProductDetails(expectedProducts);
    }

    private int extractPrice(String priceText) {
        return Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
    }
}