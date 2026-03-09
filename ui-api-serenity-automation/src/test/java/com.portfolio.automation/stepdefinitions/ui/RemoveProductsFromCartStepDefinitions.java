package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.tasks.ui.ManageCart;
import io.cucumber.java.en.When;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RemoveProductsFromCartStepDefinitions {

    @When("they remove the following products from the cart")
    public void theyRemoveTheFollowingProductsFromTheCart(List<String> products) {
        theActorInTheSpotlight().attemptsTo(
                ManageCart.removeProducts(products)
        );
    }
}
