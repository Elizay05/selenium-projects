package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.api.ApiEndpoints;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetBrands implements Task {

    private final String endpoint = ApiEndpoints.BRANDS_LIST;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(endpoint)
        );
    }

    public static GetBrands fromApi() {
        return new GetBrands();
    }
}
