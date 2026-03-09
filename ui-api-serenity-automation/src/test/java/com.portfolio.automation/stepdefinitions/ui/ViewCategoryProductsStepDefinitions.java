package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.questions.ui.CategoryTitle;
import com.portfolio.automation.tasks.ui.OpenCategory;
import com.portfolio.automation.tasks.ui.SelectSubCategory;
import com.portfolio.automation.ui.components.CategoriesComponent;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;

public class ViewCategoryProductsStepDefinitions {

    @Then("categories should be visible on the left sidebar")
    public void categoriesShouldBeVisible() {
        theActorInTheSpotlight().should(
                seeThat(the(CategoriesComponent.CATEGORY.of("Women")), isVisible())
        );
    }

    @When("they open the {string} category")
    public void theyOpenTheCategory(String category) {
        theActorInTheSpotlight().attemptsTo(
                OpenCategory.called(category)
        );
    }

    @When("they select the {string} subcategory from {string}")
    public void theySelectSubcategory(String subcategory, String category) {
        theActorInTheSpotlight().attemptsTo(
                SelectSubCategory.called(category, subcategory)
        );

    }

    @Then("the category page for {string} should be visible")
    public void categoryPageShouldBeVisible(String expectedTitle) {
        theActorInTheSpotlight().should(
                seeThat(CategoryTitle.text(), containsString(expectedTitle.toLowerCase()))
        );
    }
}
