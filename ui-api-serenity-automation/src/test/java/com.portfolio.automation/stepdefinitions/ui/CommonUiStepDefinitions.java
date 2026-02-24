package com.portfolio.automation.stepdefinitions.ui;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.annotations.Managed;

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
}
