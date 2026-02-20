package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.ApiEndpoints;
import com.portfolio.automation.constants.ApiJsonKeys;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostVerifyLogin implements Task {

    private final String endpoint = ApiEndpoints.VERIFY_LOGIN;
    private final String email;
    private final String password;

    public PostVerifyLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(endpoint)
                        .with(req -> req
                                .contentType(ContentType.URLENC)
                                .formParam(ApiJsonKeys.EMAIL, email)
                                .formParam(ApiJsonKeys.PASSWORD, password))
        );

        System.out.println(SerenityRest.lastResponse().asString());
    }

    public static PostVerifyLogin withCredentials(String email, String password) {
        return new PostVerifyLogin(email, password);
    }
}
