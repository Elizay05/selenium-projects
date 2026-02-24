package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.api.ApiEndpoints;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.Map;

public class GetUserDetailByEmail implements Task {

    private final String endpoint = ApiEndpoints.GET_USER_DETAIL_BY_EMAIL;
    private final Map<String, Object> params;

    public GetUserDetailByEmail(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource(endpoint)
                        .with(req -> req
                                .queryParams(params))
        );

        System.out.println(SerenityRest.lastResponse().asString());
    }

    public static GetUserDetailByEmail withEmail(Map<String, Object> params) {
        return new GetUserDetailByEmail(params);
    }
}
