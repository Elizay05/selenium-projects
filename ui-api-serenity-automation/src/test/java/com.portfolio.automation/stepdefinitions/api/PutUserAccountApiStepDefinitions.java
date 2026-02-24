package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.constants.api.ApiJsonKeys;
import com.portfolio.automation.tasks.api.PutUserAccount;
import com.portfolio.automation.utils.ParamsBuilder;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PutUserAccountApiStepDefinitions {

    @When("they update account with created credentials")
    public void theyUpdateAccountWithCreatedCredentials() {
        Map<String, Object> params = ParamsBuilder
                .with(ApiJsonKeys.EMAIL, theActorInTheSpotlight().recall(ApiJsonKeys.EMAIL))
                .and(ApiJsonKeys.PASSWORD, theActorInTheSpotlight().recall(ApiJsonKeys.PASSWORD))
                .and(ApiJsonKeys.NAME, "Updated Name")
                .build();

        theActorInTheSpotlight().attemptsTo(
                PutUserAccount.withParams(params)
        );
    }

    @When("they update account with email {string} and password {string}")
    public void theyUpdateAccountWithInvalidCredentials(String email, String password) {
        Map<String, Object> params = ParamsBuilder
                .with(ApiJsonKeys.EMAIL, email)
                .and(ApiJsonKeys.PASSWORD, password)
                .build();

        theActorInTheSpotlight().attemptsTo(
                PutUserAccount.withParams(params)
        );
    }

    @When("they update an account without email")
    public void theyUpdateAnAccountWithoutEmail() {
        Map<String, Object> params = ParamsBuilder
                .with(ApiJsonKeys.PASSWORD, "123456")
                .build();

        theActorInTheSpotlight().attemptsTo(
                PutUserAccount.withParams(params)
        );
    }

    @When("they update an account without password")
    public void theyUpdateAnAccountWithoutPassword() {
        Map<String, Object> params = ParamsBuilder
                .with(ApiJsonKeys.EMAIL, "test@test.com")
                .build();

        theActorInTheSpotlight().attemptsTo(
                PutUserAccount.withParams(params)
        );
    }

    @When("they update an account without credentials")
    public void updateWithoutCredentials() {

        theActorInTheSpotlight().attemptsTo(
                PutUserAccount.withParams(new HashMap<>())
        );
    }
}
