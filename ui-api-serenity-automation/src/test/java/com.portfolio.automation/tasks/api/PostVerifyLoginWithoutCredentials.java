package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.ApiEndpoints;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostVerifyLoginWithoutCredentials implements Task {

    private final String endpoint = ApiEndpoints.VERIFY_LOGIN;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(endpoint)
                        .with(req -> req
                                .contentType(ContentType.URLENC))
        );

        System.out.println(SerenityRest.lastResponse().asString());
    }

    public static PostVerifyLoginWithoutCredentials request() {
        return new PostVerifyLoginWithoutCredentials();
    }
}
