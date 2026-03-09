package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.tasks.ui.AddSearchedProductsToCart;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SearchProductVerifyCartStepDefinitions {

    @When("they add searched products to the cart")
    public void addSearchedProductsToCart() {
        theActorInTheSpotlight().attemptsTo(
                AddSearchedProductsToCart.now()
        );

    }
}
