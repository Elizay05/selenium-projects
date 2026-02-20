package com.portfolio.automation.questions.api;

import com.portfolio.automation.constants.ApiJsonKeys;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

public class ProductsHaveRequiredFields implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        List<Map<String, Object>> products =
                SerenityRest.lastResponse()
                        .jsonPath()
                        .getList(ApiJsonKeys.PRODUCTS);

        return products.stream().allMatch(product ->
                product.containsKey(ApiJsonKeys.ID) &&
                        product.containsKey(ApiJsonKeys.NAME) &&
                        product.containsKey(ApiJsonKeys.PRICE) &&
                        product.containsKey(ApiJsonKeys.BRAND)
        );
    }

    public static ProductsHaveRequiredFields areValid() {
        return new ProductsHaveRequiredFields();
    }
}
