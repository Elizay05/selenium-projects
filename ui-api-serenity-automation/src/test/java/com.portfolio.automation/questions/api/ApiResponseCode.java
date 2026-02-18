package com.portfolio.automation.questions.api;

import com.portfolio.automation.models.ApiResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ApiResponseCode implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {

        return SerenityRest.lastResponse()
                .as(ApiResponse.class)
                .getResponseCode();
    }

    public static ApiResponseCode is() {
        return new ApiResponseCode();
    }
}
