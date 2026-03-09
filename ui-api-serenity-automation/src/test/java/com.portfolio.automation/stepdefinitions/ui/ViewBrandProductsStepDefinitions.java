package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.questions.ui.BrandTitle;
import com.portfolio.automation.tasks.ui.OpenBrand;
import com.portfolio.automation.ui.components.BrandsComponent;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;

public class ViewBrandProductsStepDefinitions {

    @Then("brands should be visible on the left sidebar")
    public void brandsShouldBeVisible() {
        theActorInTheSpotlight().should(seeThat(the(BrandsComponent.BRAND.of("Polo")), isVisible()));
    }

    @When("they open the {string} brand")
    public void theyOpenTheBrand(String brand) {
        theActorInTheSpotlight().attemptsTo(OpenBrand.called(brand));
    }

    @Then("the brand page for {string} should be visible")
    public void brandPageShouldBeVisible(String brand) {
        theActorInTheSpotlight().should(seeThat(BrandTitle.text(), containsString(brand.toLowerCase())));
    }
}
