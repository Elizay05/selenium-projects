package com.portfolio.automation.questions.api;

import com.portfolio.automation.models.ApiResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ApiResponseMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse()
                .as(ApiResponse.class)
                .getMessage();
    }

    public static ApiResponseMessage is() {
        return new ApiResponseMessage();
    }
}
