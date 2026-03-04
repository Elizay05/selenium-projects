package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.constants.ui.ActorMemoryKeys;
import com.portfolio.automation.constants.ui.UiRoutes;
import com.portfolio.automation.data.ui.UiTestData;
import com.portfolio.automation.models.ui.UiLoginData;
import com.portfolio.automation.models.ui.UiRegistrationData;
import com.portfolio.automation.questions.ui.AccountStatus;
import com.portfolio.automation.questions.ui.CurrentUrl;
import com.portfolio.automation.tasks.ui.LoginWithCredentials;
import com.portfolio.automation.ui.SignupLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;

public class LoginUserStepDefinitions {

    @Then("the Login to your account section should be visible")
    public void theLoginToYourAccountSectionShouldBeVisible() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.current(), containsString(UiRoutes.SIGNUP_LOGIN)));
        theActorInTheSpotlight().should(seeThat(the((SignupLoginPage.LOGIN_TITLE)), isVisible()));
    }

    @When("they login with the registered credentials")
    public void theyLoginWithTheRegisteredCredentials() {

        UiRegistrationData data =
                theActorInTheSpotlight().recall(ActorMemoryKeys.REGISTERED_USER);

        theActorInTheSpotlight().attemptsTo(
                LoginWithCredentials.using(
                        data.getEmail(),
                        data.getPassword()
                )
        );
    }

    @When("they login with incorrect credentials")
    public void theyLoginWithIncorrectCredentials() {
        UiLoginData invalidUser = new UiLoginData(
                UiTestData.INVALID_EMAIL,
                UiTestData.INVALID_PASSWORD
        );

        theActorInTheSpotlight().attemptsTo(
                LoginWithCredentials.using(
                        invalidUser.getEmail(),
                        invalidUser.getPassword()
                )
        );
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        theActorInTheSpotlight().should(
                seeThat(AccountStatus.loginErrorIsVisible())
        );
    }
}
