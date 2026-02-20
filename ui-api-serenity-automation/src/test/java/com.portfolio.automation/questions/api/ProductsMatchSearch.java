package com.portfolio.automation.questions.api;

import com.portfolio.automation.constants.ApiJsonKeys;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class ProductsMatchSearch implements Question<Boolean> {

    private final String searchTerm;

    public ProductsMatchSearch(String searchTerm) {
        this.searchTerm = searchTerm.toLowerCase();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        List<String> productNames =
                SerenityRest.lastResponse()
                        .jsonPath()
                        .getList(ApiJsonKeys.PRODUCTS_NAME);

        return productNames.stream()
                .anyMatch(name -> name.toLowerCase().contains(searchTerm));
    }

    public static ProductsMatchSearch withTerm(String term) {
        return new ProductsMatchSearch(term);
    }
}
