package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.constants.ui.UiRoutes;
import com.portfolio.automation.data.ui.UiTestData;
import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.models.ui.UiContactData;
import com.portfolio.automation.questions.ui.CurrentUrl;
import com.portfolio.automation.tasks.ui.FillContactForm;
import com.portfolio.automation.ui.pages.ContactUsPage;
import com.portfolio.automation.ui.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;

public class ContactUsFormStepDefinitions {

    @When("they navigate to Contact Us")
    public void theyNavigateToContactUs() {
        theActorInTheSpotlight().attemptsTo(
                SafeClick.on(HomePage.CONTACT_US_BUTTON)
        );
    }

    @Then("the Get In Touch section should be visible")
    public void theGetInTouchSectionShouldBeVisible() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.current(), containsString(UiRoutes.CONTACT_US)));
        theActorInTheSpotlight().should(seeThat(the(ContactUsPage.GET_IN_TOUCH_TITLE), isVisible()));
    }

    @When("they submit the contact form")
    public void theySubmitTheContactForm() {
        UiContactData data = new UiContactData(
                UiTestData.CONTACT_FORM_NAME,
                UiTestData.CONTACT_FORM_EMAIL,
                UiTestData.CONTACT_FORM_SUBJECT,
                UiTestData.CONTACT_FORM_MESSAGE,
                UiTestData.CONTACT_FORM_FILE_PATH
        );


        theActorInTheSpotlight().attemptsTo(
                FillContactForm.with(data)
        );
    }

    @Then("a success message should be displayed")
    public void aSuccessMessageShouldBeDisplayed() {
        theActorInTheSpotlight().should(seeThat(the(ContactUsPage.SUCCESS_MESSAGE), isVisible()));
    }

    @When("they return to the home page")
    public void theyReturnToTheHomePage() {
        theActorInTheSpotlight().attemptsTo(SafeClick.on(ContactUsPage.HOME_BUTTON));
    }

    @Then("they should be on the home page")
    public void theyShouldBeOnTheHomePage() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.current(), containsString(UiRoutes.HOME)));
    }
}
