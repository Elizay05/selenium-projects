package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.constants.ui.UiRoutes;
import com.portfolio.automation.questions.ui.CurrentUrl;
import com.portfolio.automation.questions.ui.ProductDetails;
import com.portfolio.automation.tasks.ui.OpenFirstProduct;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class VerifyProductDetailPageStepDefinitions {

    @When("they open the first product")
    public void theyOpenTheFirstProduct() {
        theActorInTheSpotlight().attemptsTo(OpenFirstProduct.now());
    }

    @Then("they should see the product details")
    public void theyShouldSeeTheProductDetails() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.current(), containsString(UiRoutes.PRODUCT_DETAILS)));
        theActorInTheSpotlight().should(seeThat(ProductDetails.areVisible()));
    }
}
