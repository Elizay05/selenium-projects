package com.portfolio.automation.questions.api;

import com.portfolio.automation.constants.api.ApiJsonKeys;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductsListSize implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse()
                .jsonPath()
                .getList(ApiJsonKeys.PRODUCTS)
                .size();
    }

    public static ProductsListSize value() {
        return new ProductsListSize();
    }
}
