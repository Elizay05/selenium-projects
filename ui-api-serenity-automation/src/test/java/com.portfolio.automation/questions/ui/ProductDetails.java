package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.pages.ProductDetailPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductDetails implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        return ProductDetailPage.PRODUCT_NAME.resolveFor(actor).isVisible()
                && ProductDetailPage.CATEGORY.resolveFor(actor).isVisible()
                && ProductDetailPage.PRICE.resolveFor(actor).isVisible()
                && ProductDetailPage.AVAILABILITY.resolveFor(actor).isVisible()
                && ProductDetailPage.CONDITION.resolveFor(actor).isVisible()
                && ProductDetailPage.BRAND.resolveFor(actor).isVisible();
    }

    public static ProductDetails areVisible(){
        return new ProductDetails();
    }
}
