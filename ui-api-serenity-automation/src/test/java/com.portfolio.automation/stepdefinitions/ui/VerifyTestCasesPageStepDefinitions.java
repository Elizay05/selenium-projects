package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.questions.ui.TestCasesTitle;
import com.portfolio.automation.tasks.ui.GoToTestCasesPage;
import com.portfolio.automation.tasks.ui.OpenHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class VerifyTestCasesPageStepDefinitions {

    @When("they open the home page")
    public void theyOpenTheHomePage() {
        theActorInTheSpotlight().attemptsTo(OpenHomePage.now());
    }

    @When("they navigate to Test Cases")
    public void theyNavigateToTestCases() {
        theActorInTheSpotlight().attemptsTo(GoToTestCasesPage.fromHome());
    }

    @Then("the Test Cases page title should be visible")
    public void theTestCasesPageTitleShouldBeVisible() {
        theActorInTheSpotlight().should(
                seeThat(TestCasesTitle.value(), equalTo("TEST CASES"))
        );
    }
}
