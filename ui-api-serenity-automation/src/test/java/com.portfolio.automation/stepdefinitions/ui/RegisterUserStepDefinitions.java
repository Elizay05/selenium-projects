package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.constants.ui.ActorMemoryKeys;
import com.portfolio.automation.constants.ui.UiRoutes;
import com.portfolio.automation.models.ui.UiRegistrationData;
import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.questions.ui.CurrentUrl;
import com.portfolio.automation.questions.ui.AccountStatus;
import com.portfolio.automation.tasks.ui.ContinueAfterAccountCreation;
import com.portfolio.automation.tasks.ui.RegisterNewUser;
import com.portfolio.automation.ui.SignupLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class RegisterUserStepDefinitions {
    @Then("the New User Signup section should be visible")
    public void theNewUserSignupSectionShouldBeVisible() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.current(), containsString(UiRoutes.SIGNUP_LOGIN)));
        theActorInTheSpotlight().should(seeThat(the((SignupLoginPage.NEW_USER_SIGNUP_TITLE)), isVisible()));
    }

    @When("they register a new account")
    public void theyRegisterANewAccount() {
        theActorInTheSpotlight().attemptsTo(
                RegisterNewUser.withDefaultData()
        );
    }

    @Then("the account should be created")
    public void theAccountShouldBeCreated() {
        theActorInTheSpotlight().should(
                seeThat(AccountStatus.isCreated())
        );
    }

    @When("they continue after account creation")
    public void theyContinueAfterAccountCreation() {
        theActorInTheSpotlight().attemptsTo(
                ContinueAfterAccountCreation.now()
        );
    }

    @When("they try to register with an existing email")
    public void theyTryToRegisterWithAnExistingEmail() {

        UiRegistrationData data =
                theActorInTheSpotlight().recall(ActorMemoryKeys.REGISTERED_USER);

        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(data.getName()).into(SignupLoginPage.SIGNUP_NAME),
                Enter.theValue(data.getEmail()).into(SignupLoginPage.SIGNUP_EMAIL),
                SafeClick.on(SignupLoginPage.SIGNUP_BUTTON)
        );
    }

    @Then("an existing email error message should be displayed")
    public void anExistingEmailErrorMessageShouldBeDisplayed() {
        theActorInTheSpotlight().should(
                seeThat(the(SignupLoginPage.SIGNUP_EXISTING_EMAIL_ERROR), isVisible())
        );
    }
}
