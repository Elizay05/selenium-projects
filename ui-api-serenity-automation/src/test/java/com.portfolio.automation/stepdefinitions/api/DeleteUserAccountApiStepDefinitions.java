package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.constants.api.ApiJsonKeys;
import com.portfolio.automation.tasks.api.DeleteUserAccount;
import com.portfolio.automation.utils.ParamsBuilder;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteUserAccountApiStepDefinitions {

    @When("they delete account with created credentials")
    public void theyDeleteAccountWithCreatedCredentials() {
        Map<String, Object> params = ParamsBuilder
                .with(ApiJsonKeys.EMAIL, theActorInTheSpotlight().recall(ApiJsonKeys.EMAIL))
                .and(ApiJsonKeys.PASSWORD, theActorInTheSpotlight().recall(ApiJsonKeys.PASSWORD))
                .build();

        theActorInTheSpotlight().attemptsTo(
                DeleteUserAccount.withParams(params)
        );
    }

    @When("they delete an account with email {string} and password {string}")
    public void theyDeleteAccountWithInvalidCredentials(String email, String password) {
        Map<String, Object> params = ParamsBuilder
                .with(ApiJsonKeys.EMAIL, email)
                .and(ApiJsonKeys.PASSWORD, password)
                .build();

        theActorInTheSpotlight().attemptsTo(
                DeleteUserAccount.withParams(params)
        );
    }

    @When("they delete an account without email")
    public void theyDeleteAnAccountWithoutEmail() {
        Map<String, Object> params = ParamsBuilder
                .with(ApiJsonKeys.PASSWORD, "123456")
                .build();

        theActorInTheSpotlight().attemptsTo(
                DeleteUserAccount.withParams(params)
        );
    }

    @When("they delete an account without password")
    public void theyDeleteAnAccountWithoutPassword() {
        Map<String, Object> params = ParamsBuilder
                .with(ApiJsonKeys.EMAIL, "test@test.com")
                .build();

        theActorInTheSpotlight().attemptsTo(
                DeleteUserAccount.withParams(params)
        );
    }

    @When("they delete an account without credentials")
    public void theyDeleteAnAccountWithoutCredentials() {
        theActorInTheSpotlight().attemptsTo(
                DeleteUserAccount.withParams(new HashMap<>())
        );
    }
}
