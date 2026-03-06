package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.constants.ui.UiRoutes;
import com.portfolio.automation.questions.ui.CurrentUrl;
import com.portfolio.automation.questions.ui.ProductsList;
import com.portfolio.automation.tasks.ui.GoToProductsPage;
import com.portfolio.automation.ui.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;

public class VerifyProductsPageStepDefinitions {

    @When("they navigate to products page")
    public void theyNavigateToProductsPage() {
        theActorInTheSpotlight().attemptsTo(
                GoToProductsPage.now()
        );
    }

    @Then("the All Products page title should be visible")
    public void theAllProductsPageTitleShouldBeVisible() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.current(), containsString(UiRoutes.PRODUCTS)));
        theActorInTheSpotlight().should(seeThat(the((ProductsPage.ALL_PRODUCTS_TITLE)), isVisible()));
    }


    @Then("the products list should be visible")
    public void theProductsListShouldBeVisible() {
        theActorInTheSpotlight().should(
                seeThat(ProductsList.isVisible())
        );
    }
}
