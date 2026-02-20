package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.questions.api.ProductsHaveRequiredFields;
import com.portfolio.automation.questions.api.ProductsListSize;
import com.portfolio.automation.tasks.api.GetProducts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class GetProductsApiStepDefinitions {

    @When("they request all products")
    public void theyRequestAllProducts() {
        theActorInTheSpotlight().attemptsTo(GetProducts.fromApi());
    }

    @And("each product should contain the required fields")
    public void eachProductShouldContainTheRequiredFields() {
        theActorInTheSpotlight().should(
                seeThat(ProductsHaveRequiredFields.areValid(), equalTo(true))
        );
    }
}
