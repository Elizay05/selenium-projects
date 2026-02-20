package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.constants.ApiJsonKeys;
import com.portfolio.automation.tasks.api.PostVerifyLogin;
import com.portfolio.automation.tasks.api.PostVerifyLoginWithoutCredentials;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostVerifyLoginApiStepDefinitions {

    @When("they verify login with created credentials")
    public void theyVerifyLoginWithCreatedCredentials() {

        String email = theActorInTheSpotlight().recall(ApiJsonKeys.EMAIL);
        String password = theActorInTheSpotlight().recall(ApiJsonKeys.PASSWORD);

        theActorInTheSpotlight().attemptsTo(
                PostVerifyLogin.withCredentials(email, password)
        );
    }

    @When("they verify login with email {string} and password {string}")
    public void theyVerifyLoginWithEmailAndPassword(String email, String password) {
        theActorInTheSpotlight().attemptsTo(
                PostVerifyLogin.withCredentials(email, password)
        );
    }

    @When("they verify login without credentials")
    public void theyVerifyLoginWithoutCredentials() {
        theActorInTheSpotlight().attemptsTo(
                PostVerifyLoginWithoutCredentials.request()
        );
    }
}
