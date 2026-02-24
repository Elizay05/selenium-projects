package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.tasks.ui.OpenHomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

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
}
