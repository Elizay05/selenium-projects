package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.questions.ui.AccountStatus;
import com.portfolio.automation.tasks.ui.DeleteAccount;
import com.portfolio.automation.tasks.ui.GoToSignupLoginPage;
import com.portfolio.automation.tasks.ui.Logout;
import com.portfolio.automation.tasks.ui.OpenHomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class CommonUiStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver browser;

    @Before("@ui")
    public void setTheStageForUi() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user is browsing Automation Exercise")
    public void theUserIsBrowsingAutomationExercise() {
        OnStage.theActorCalled("UI User")
                .can(BrowseTheWeb.with(browser));
    }

    @When("they open the home page")
    public void theyOpenTheHomePage() {
        theActorInTheSpotlight().attemptsTo(OpenHomePage.now());
    }

    @When("they navigate to Signup Login")
    public void theyNavigateToSignupLogin() {
        theActorInTheSpotlight().attemptsTo(GoToSignupLoginPage.fromHome());
    }

    @Then("they should be logged in")
    public void theyShouldBeLoggedIn() {
        theActorInTheSpotlight().should(
                seeThat(AccountStatus.isLoggedIn())
        );
    }

    @When("they delete the account")
    public void theyDeleteTheAccount() {
        theActorInTheSpotlight().attemptsTo(
                DeleteAccount.now()
        );
    }

    @Then("the account should be deleted")
    public void theAccountShouldBeDeleted() {
        theActorInTheSpotlight().should(
                seeThat(AccountStatus.isDeleted())
        );
    }

    @When("they logout")
    public void theyLogout() {
        theActorInTheSpotlight().attemptsTo(
                Logout.now()
        );
    }
}
