package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.questions.api.ProductsListSize;
import com.portfolio.automation.questions.api.ProductsMatchSearch;
import com.portfolio.automation.tasks.api.PostSearchProducts;
import com.portfolio.automation.tasks.api.PostSearchProductsWithoutTerm;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class PostSearchProductsApiStepDefinitions {

    @When("they search products with term {string}")
    public void theySearchProductsWithTerm(String term) {
        theActorInTheSpotlight().attemptsTo(PostSearchProducts.withTerm(term)
        );
    }

    @And("all products should match the search term {string}")
    public void allProductsShouldMatchTheSearchTerm(String term) {
        theActorInTheSpotlight().should(
                seeThat(ProductsMatchSearch.withTerm(term), equalTo(true))
        );
    }

    @When("they search products without term")
    public void theySearchProductsWithoutTerm() {
        theActorInTheSpotlight().attemptsTo(PostSearchProductsWithoutTerm.request()
        );
    }

    @And("the products list should be empty")
    public void theProductsListShouldBeEmpty() {
        theActorInTheSpotlight().should(
                seeThat(ProductsListSize.value(), equalTo(0))
        );
    }
}
