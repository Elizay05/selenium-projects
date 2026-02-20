package com.portfolio.automation.questions.api;

import com.portfolio.automation.constants.ApiJsonKeys;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

public class BrandsHaveRequiredFields implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        List<Map<String, Object>> brands =
                SerenityRest.lastResponse()
                        .jsonPath()
                        .getList(ApiJsonKeys.BRANDS);

        return brands.stream().allMatch(brand ->
                brand.containsKey(ApiJsonKeys.ID) &&
                        brand.containsKey(ApiJsonKeys.BRAND)
        );
    }

    public static BrandsHaveRequiredFields areValid() {
        return new BrandsHaveRequiredFields();
    }
}
