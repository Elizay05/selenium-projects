package com.portfolio.automation.questions.api;

import com.portfolio.automation.constants.ApiJsonKeys;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BrandsListSize implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse()
                .jsonPath()
                .getList(ApiJsonKeys.BRANDS)
                .size();
    }

    public static BrandsListSize value() {
        return new BrandsListSize();
    }
}
