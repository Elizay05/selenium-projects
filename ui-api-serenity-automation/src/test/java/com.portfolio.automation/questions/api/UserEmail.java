package com.portfolio.automation.questions.api;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UserEmail implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse()
                .jsonPath()
                .getString("user.email");
    }

    public static UserEmail value() {
        return new UserEmail();
    }
}
