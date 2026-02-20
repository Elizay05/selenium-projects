package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.tasks.api.PutBrands;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PutBrandsApiStepDefinitions {

    @When("they try to put to brands list")
    public void theyTryToPutToBrandsList() {
        theActorInTheSpotlight().attemptsTo(PutBrands.toApi());
    }
}
