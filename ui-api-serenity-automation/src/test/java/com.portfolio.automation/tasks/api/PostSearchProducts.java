package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.ApiEndpoints;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostSearchProducts implements Task {

    private final String endpoint = ApiEndpoints.SEARCH_PRODUCT;
    private final String term;

    public PostSearchProducts(String term) {
        this.term = term;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(endpoint)
                        .with(req -> req
                                .contentType(ContentType.URLENC)
                                .formParams("search_product", term))
        );

        System.out.println(SerenityRest.lastResponse().asString());
    }

    public static PostSearchProducts withTerm(String term) {
        return new PostSearchProducts(term);
    }
}
