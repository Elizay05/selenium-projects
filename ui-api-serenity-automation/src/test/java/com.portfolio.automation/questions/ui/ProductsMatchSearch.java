package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductsMatchSearch implements Question<Boolean> {

    private final String searchTerm;

    public ProductsMatchSearch(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return ProductsPage.PRODUCT_LIST.resolveAllFor(actor)
                .stream()
                .allMatch(product ->
                        product.getText()
                                .toLowerCase()
                                .contains(searchTerm.toLowerCase())
                );
    }

    public static ProductsMatchSearch withTerm(String searchTerm){
        return new ProductsMatchSearch(searchTerm);
    }
}
