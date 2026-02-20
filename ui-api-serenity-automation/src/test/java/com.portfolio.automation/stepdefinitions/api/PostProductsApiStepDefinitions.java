package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.tasks.api.PostProducts;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostProductsApiStepDefinitions {

    @When("they try to post to products list")
    public void theyTryToPostToProductsList() {
        theActorInTheSpotlight().attemptsTo(PostProducts.toApi());
    }
}
