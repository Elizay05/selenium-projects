package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.constants.ui.UiRoutes;
import com.portfolio.automation.models.ui.UiExpectedProduct;
import com.portfolio.automation.questions.ui.CartProductDetails;
import com.portfolio.automation.questions.ui.CurrentUrl;
import com.portfolio.automation.tasks.ui.GoToCartPage;
import com.portfolio.automation.tasks.ui.ManageCart;
import com.portfolio.automation.ui.pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class AddProductsToCartStepDefinitions {

    @When("they navigate to cart page")
    public void theyNavigateToCartPage() {
        theActorInTheSpotlight().attemptsTo(GoToCartPage.now());
    }

    @When("the cart page should be visible")
    public void theCartPageShouldBeVisible() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.current(), containsString(UiRoutes.CART)));
        theActorInTheSpotlight().should(seeThat(the((CartPage.CART_SECTION)), isVisible()));
    }

    @When("they add the following products to the cart")
    public void theyAddTheFollowingProductsToTheCart(List<String> products) {
        theActorInTheSpotlight().attemptsTo(
                ManageCart.addProducts(products)
        );
    }

    @Then("the cart should contain the following products")
    public void theCartShouldContainTheFollowingProducts(List<UiExpectedProduct> expectedProducts) {

        theActorInTheSpotlight().should(
                seeThat(CartProductDetails.areCorrect(expectedProducts))
        );
    }
}
