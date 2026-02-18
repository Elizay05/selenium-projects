package com.portfolio.automation.tasks.api;

import com.portfolio.automation.constants.ApiEndpoints;
import com.portfolio.automation.models.CreateUserRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;
import java.util.Map;

public class PostUserAccount implements Task {

    private final String endpoint = ApiEndpoints.CREATE_ACCOUNT;
    private final CreateUserRequest request;

    public PostUserAccount(CreateUserRequest request) {
        this.request = request;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String, Object> formParams = new HashMap<>();

        putIfNotNull(formParams, "name", request.getName());
        putIfNotNull(formParams, "email", request.getEmail());
        putIfNotNull(formParams, "password", request.getPassword());
        putIfNotNull(formParams, "title", request.getTitle());
        putIfNotNull(formParams, "birth_date", request.getBirth_date());
        putIfNotNull(formParams, "birth_month", request.getBirth_month());
        putIfNotNull(formParams, "birth_year", request.getBirth_year());
        putIfNotNull(formParams, "firstname", request.getFirstname());
        putIfNotNull(formParams, "lastname", request.getLastname());
        putIfNotNull(formParams, "company", request.getCompany());
        putIfNotNull(formParams, "address1", request.getAddress1());
        putIfNotNull(formParams, "country", request.getCountry());
        putIfNotNull(formParams, "zipcode", request.getZipcode());
        putIfNotNull(formParams, "state", request.getState());
        putIfNotNull(formParams, "city", request.getCity());
        putIfNotNull(formParams, "mobile_number", request.getMobile_number());

        actor.attemptsTo(
                Post.to(endpoint)
                        .with(req -> req
                                .contentType(ContentType.URLENC)
                                .formParams(formParams)
                        )
        );

        System.out.println(SerenityRest.lastResponse().asString());
    }

    private void putIfNotNull(Map<String, Object> map, String key, Object value) {
        if (value != null) {
            map.put(key, value);
        }
    }

    public static PostUserAccount withData(CreateUserRequest request) {
        return new PostUserAccount(request);
    }
}