package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.ApiEndpoints;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.util.Map;

public class DeleteUserAccount implements Task {

    private final String endpoint = ApiEndpoints.DELETE_ACCOUNT;
    private final Map<String, Object> params;

    public DeleteUserAccount(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(endpoint)
                        .with(req -> req
                                .contentType(ContentType.URLENC)
                                .formParams(params))
        );

        System.out.println(SerenityRest.lastResponse().asString());
    }

    public static DeleteUserAccount withParams(Map<String, Object> params) {
        return new DeleteUserAccount(params);
    }
}
