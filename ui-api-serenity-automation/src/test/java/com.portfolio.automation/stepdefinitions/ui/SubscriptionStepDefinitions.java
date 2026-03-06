package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.data.ui.UiTestData;
import com.portfolio.automation.tasks.ui.ScrollToFooter;
import com.portfolio.automation.tasks.ui.SubscribeToNewsletter;
import com.portfolio.automation.ui.components.FooterComponent;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;

public class SubscriptionStepDefinitions {

    @When("they scroll to the footer")
    public void theyScrollToTheFooter() {
        theActorInTheSpotlight().attemptsTo(ScrollToFooter.now());
    }

    @Then("the subscription section should be visible")
    public void theSubscriptionSectionShouldBeVisible() {
        theActorInTheSpotlight().should(seeThat(the(FooterComponent.SUBSCRIPTION_TITLE), isVisible()));
    }

    @When("they subscribe with an email")
    public void theySubscribeWithAnEmail() {
        theActorInTheSpotlight().attemptsTo(SubscribeToNewsletter.withEmail(UiTestData.DYNAMIC_EMAIL));
    }

    @Then("a subscription success message should be displayed")
    public void aSubscriptionSuccessMessageShouldBeDisplayed() {
        theActorInTheSpotlight().should(seeThat(Text.of(FooterComponent.SUBSCRIPTION_SUCCESS_MESSAGE), containsString(UiTestData.SUCCESSFUL_SUBSCRIPTION_MESSAGE)));
    }
}
