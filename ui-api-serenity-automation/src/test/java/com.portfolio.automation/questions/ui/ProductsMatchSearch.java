package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductsMatchSearch implements Question<Boolean> {

    private final String searchTerm;

    public ProductsMatchSearch(String searchTerm) {
        this.searchTerm = searchTerm.toLowerCase();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return ProductsPage.PRODUCT_LIST.resolveAllFor(actor)
                .stream()
                .map(product -> product.findBy(".productinfo p").getText().toLowerCase())
                .allMatch(name -> name.contains(searchTerm));
    }

    public static ProductsMatchSearch withTerm(String searchTerm){
        return new ProductsMatchSearch(searchTerm);
    }
}
