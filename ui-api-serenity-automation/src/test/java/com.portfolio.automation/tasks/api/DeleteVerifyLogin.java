package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.api.ApiEndpoints;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteVerifyLogin implements Task {

    private final String endpoint = ApiEndpoints.VERIFY_LOGIN;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(endpoint)
        );

        System.out.println(SerenityRest.lastResponse().asString());
    }

    public static DeleteVerifyLogin toApi() {
        return new DeleteVerifyLogin();
    }
}
