package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.questions.ui.CartProductDetails;
import com.portfolio.automation.questions.ui.CartProducts;
import com.portfolio.automation.tasks.ui.AddProductToCart;
import com.portfolio.automation.tasks.ui.ContinueShopping;
import com.portfolio.automation.tasks.ui.GoToCartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AddProductsToCartStepDefinitions {

    @When("they navigate to cart page")
    public void theyNavigateToCartPage() {
        theActorInTheSpotlight().attemptsTo(GoToCartPage.now());
    }

    @When("they add the first product to the cart")
    public void theyAddTheFirstProduct() {
        theActorInTheSpotlight().attemptsTo(AddProductToCart.firstProduct());
    }

    @When("they continue shopping")
    public void theyContinueShopping() {
        theActorInTheSpotlight().attemptsTo(ContinueShopping.now());
    }

    @When("they add the second product to the cart")
    public void theyAddTheSecondProduct() {
        theActorInTheSpotlight().attemptsTo(AddProductToCart.secondProduct());
    }

    @Then("both products should be visible in the cart")
    public void bothProductsShouldBeVisibleInTheCart() {
        theActorInTheSpotlight().should(seeThat(CartProducts.areVisible()));
    }

    @Then("their prices, quantity and total should be correct")
    public void theirPricesQuantityAndTotalShouldBeCorrect() {
        theActorInTheSpotlight().should(
                seeThat(CartProductDetails.areCorrect())
        );
    }
}
