package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.tasks.api.DeleteVerifyLogin;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteVerifyLoginApiStepDefinitions {

    @When("they try to delete to verify login")
    public void theyTryToDeleteToVerifyLogin() {
        theActorInTheSpotlight().attemptsTo(DeleteVerifyLogin.toApi());
    }
}
