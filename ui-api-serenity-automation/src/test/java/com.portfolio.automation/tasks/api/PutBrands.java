package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.ApiEndpoints;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutBrands implements Task {

    private final String endpoint = ApiEndpoints.BRANDS_LIST;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(endpoint)
        );

        System.out.println(SerenityRest.lastResponse().asString());
    }

    public static PutBrands toApi() {
        return new PutBrands();
    }
}
