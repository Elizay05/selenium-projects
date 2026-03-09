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

    @When("they search for {string}")
    public void theySearchFor(String searchTerm) {
        theActorInTheSpotlight().attemptsTo(SearchProduct.called(searchTerm));
    }

    @Then("the searched products section should be visible")
    public void theSearchedProductsSectionShouldBeVisible() {
        theActorInTheSpotlight().should(seeThat(the((ProductsPage.SEARCHED_PRODUCTS_TITLE)), isVisible()));
    }

    @Then("all products related to {string} should be visible")
    public void allProductsRelatedToShouldBeVisible(String searchTerm) {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.current(), containsString(UiTestData.SEARCH_TERM_PATH + searchTerm)));
        theActorInTheSpotlight().should(seeThat(ProductsMatchSearch.withTerm(searchTerm)));
    }
}
