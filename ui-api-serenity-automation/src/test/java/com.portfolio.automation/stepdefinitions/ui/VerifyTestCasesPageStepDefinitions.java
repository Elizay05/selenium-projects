package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.constants.ui.UiRoutes;
import com.portfolio.automation.constants.ui.UiTexts;
import com.portfolio.automation.questions.ui.CurrentUrl;
import com.portfolio.automation.tasks.ui.GoToTestCasesPage;
import com.portfolio.automation.ui.TestCasesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class VerifyTestCasesPageStepDefinitions {

    @When("they navigate to Test Cases")
    public void theyNavigateToTestCases() {
        theActorInTheSpotlight().attemptsTo(GoToTestCasesPage.fromHome());
    }

    @Then("the Test Cases page title should be visible")
    public void theTestCasesPageTitleShouldBeVisible() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.current(), containsString(UiRoutes.TEST_CASES)));
        theActorInTheSpotlight().should(seeThat(Text.of(TestCasesPage.TITLE), equalToIgnoringCase(UiTexts.TEST_CASES_TITLE)));
    }
}
