package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.ApiEndpoints;
import com.portfolio.automation.constants.ApiJsonKeys;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.util.HashMap;
import java.util.Map;

public class DeleteUserAccountWithoutPassword implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String, Object> params = new HashMap<>();
        params.put(ApiJsonKeys.EMAIL, "test@test.com");

        actor.attemptsTo(
                Delete.from(ApiEndpoints.DELETE_ACCOUNT)
                        .with(req -> req
                                .contentType(ContentType.URLENC)
                                .formParams(params))
        );
    }

    public static DeleteUserAccountWithoutPassword request() {
        return new DeleteUserAccountWithoutPassword();
    }
}
