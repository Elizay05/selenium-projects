package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.constants.api.ApiJsonKeys;
import com.portfolio.automation.tasks.api.PostVerifyLogin;
import com.portfolio.automation.utils.ParamsBuilder;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostVerifyLoginApiStepDefinitions {

    @When("they verify login with created credentials")
    public void theyVerifyLoginWithCreatedCredentials() {
        Map<String, Object> params = ParamsBuilder
                .with(ApiJsonKeys.EMAIL, theActorInTheSpotlight().recall(ApiJsonKeys.EMAIL))
                .and(ApiJsonKeys.PASSWORD, theActorInTheSpotlight().recall(ApiJsonKeys.PASSWORD))
                .build();

        theActorInTheSpotlight().attemptsTo(
                PostVerifyLogin.withParams(params)
        );
    }

    @When("they verify login with email {string} and password {string}")
    public void theyVerifyLoginWithEmailAndPassword(String email, String password) {
        Map<String, Object> params = ParamsBuilder
                .with(ApiJsonKeys.EMAIL, email)
                .and(ApiJsonKeys.PASSWORD, password)
                .build();

        theActorInTheSpotlight().attemptsTo(
                PostVerifyLogin.withParams(params)
        );
    }

    @When("they verify login without credentials")
    public void theyVerifyLoginWithoutCredentials() {
        theActorInTheSpotlight().attemptsTo(
                PostVerifyLogin.withParams(new HashMap<>())
        );
    }
}
