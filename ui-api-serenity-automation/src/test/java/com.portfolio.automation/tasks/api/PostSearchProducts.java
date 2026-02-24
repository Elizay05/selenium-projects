package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.api.ApiEndpoints;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

public class PostSearchProducts implements Task {

    private final String endpoint = ApiEndpoints.SEARCH_PRODUCT;
    private final Map<String, Object> params;

    public PostSearchProducts(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(endpoint)
                        .with(req -> req
                                .contentType(ContentType.URLENC)
                                .formParams(params))
        );

        System.out.println(SerenityRest.lastResponse().asString());
    }

    public static PostSearchProducts withParams(Map<String, Object> params) {
        return new PostSearchProducts(params);
    }
}
