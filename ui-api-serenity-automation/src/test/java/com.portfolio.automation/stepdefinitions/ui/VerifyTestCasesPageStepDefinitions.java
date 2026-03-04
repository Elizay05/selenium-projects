package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.constants.ui.UiRoutes;
import com.portfolio.automation.questions.ui.CurrentUrl;
import com.portfolio.automation.tasks.ui.GoToTestCasesPage;
import com.portfolio.automation.ui.TestCasesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;

public class VerifyTestCasesPageStepDefinitions {

    @When("they navigate to Test Cases")
    public void theyNavigateToTestCases() {
        theActorInTheSpotlight().attemptsTo(GoToTestCasesPage.fromHome());
    }

    @Then("the Test Cases page title should be visible")
    public void theTestCasesPageTitleShouldBeVisible() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.current(), containsString(UiRoutes.TEST_CASES)));
        theActorInTheSpotlight().should(seeThat(the((TestCasesPage.TITLE)), isVisible()));
    }
}
