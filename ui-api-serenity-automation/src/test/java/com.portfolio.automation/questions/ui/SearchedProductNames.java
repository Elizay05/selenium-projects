package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class SearchedProductNames implements Question<List<String>> {

    public static SearchedProductNames value() {
        return new SearchedProductNames();
    }

    @Override
    public List<String> answeredBy(Actor actor) {

        return ProductsPage.PRODUCT_LIST
                .resolveAllFor(actor)
                .stream()
                .map(e -> e.findBy(".productinfo p").getText())
                .toList();
    }
}
