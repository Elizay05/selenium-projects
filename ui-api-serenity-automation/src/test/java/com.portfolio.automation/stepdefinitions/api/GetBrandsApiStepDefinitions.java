package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.questions.api.BrandsHaveRequiredFields;
import com.portfolio.automation.questions.api.BrandsListSize;
import com.portfolio.automation.tasks.api.GetBrands;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class GetBrandsApiStepDefinitions {

    @When("they request all brands")
    public void theyRequestAllBrands() {
        theActorInTheSpotlight().attemptsTo(GetBrands.fromApi());
    }

    @And("the brands list should not be empty")
    public void theBrandsListShouldNotBeEmpty() {
        theActorInTheSpotlight().should(
                seeThat(BrandsListSize.value(), greaterThan(0))
        );
    }

    @And("each brand should contain the required fields")
    public void eachBrandShouldContainTheRequiredFields() {
        theActorInTheSpotlight().should(
                seeThat(BrandsHaveRequiredFields.areValid(), equalTo(true))
        );
    }
}
