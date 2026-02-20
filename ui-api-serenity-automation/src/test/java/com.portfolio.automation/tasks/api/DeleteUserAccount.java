package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.ApiEndpoints;
import com.portfolio.automation.constants.ApiJsonKeys;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteUserAccount implements Task {

    private final String endpoint = ApiEndpoints.DELETE_ACCOUNT;
    private final String email;
    private final String password;

    public DeleteUserAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(endpoint)
                        .with(req -> req
                                .contentType(ContentType.URLENC)
                                .formParam(ApiJsonKeys.EMAIL, email)
                                .formParam(ApiJsonKeys.PASSWORD, password))
        );

        System.out.println(SerenityRest.lastResponse().asString());
    }

    public static DeleteUserAccount withCredentials(String email, String password) {
        return new DeleteUserAccount(email, password);
    }
}
