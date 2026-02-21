package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.ApiEndpoints;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

public class PutUserAccount implements Task {

    private final String endpoint = ApiEndpoints.UPDATE_ACCOUNT;
    private final Map<String, Object> params;

    public PutUserAccount(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Put.to(endpoint)
                        .with(req -> req
                                .contentType(ContentType.URLENC)
                                .formParams(params))
        );

        System.out.println(SerenityRest.lastResponse().asString());
    }

    public static PutUserAccount withParams(Map<String, Object> params) {
        return new PutUserAccount(params);
    }
}
