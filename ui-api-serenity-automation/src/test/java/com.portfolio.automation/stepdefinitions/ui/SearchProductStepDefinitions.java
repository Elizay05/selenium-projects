package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.data.ui.UiTestData;
import com.portfolio.automation.questions.ui.CurrentUrl;
import com.portfolio.automation.questions.ui.ProductsMatchSearch;
import com.portfolio.automation.tasks.ui.SearchProduct;
import com.portfolio.automation.ui.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;

public class SearchProductStepDefinitions {

    @When("they search for a product")
    public void theySearchForAProduct() {
        theActorInTheSpotlight().attemptsTo(SearchProduct.called(UiTestData.SEARCH_TERM));
    }

    @Then("the searched products section should be visible")
    public void theSearchedProductsSectionShouldBeVisible() {
        theActorInTheSpotlight().should(seeThat(the((ProductsPage.SEARCHED_PRODUCTS_TITLE)), isVisible()));
    }

    @Then("the searched products should be displayed")
    public void theSearchedProductsShouldBeDisplayed() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.current(), containsString(UiTestData.SEARCH_TERM_PATH)));
        theActorInTheSpotlight().should(seeThat(ProductsMatchSearch.withTerm(UiTestData.SEARCH_TERM)));
    }
}
