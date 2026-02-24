package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.api.ApiEndpoints;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostProducts implements Task {

    private final String endpoint = ApiEndpoints.PRODUCTS_LIST;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(endpoint)
        );

        System.out.println(SerenityRest.lastResponse().asString());
    }

    public static PostProducts toApi() {
        return new PostProducts();
    }
}
