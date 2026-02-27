package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.constants.ui.UiRoutes;
import com.portfolio.automation.questions.ui.CurrentUrl;
import com.portfolio.automation.questions.ui.TheAccount;
import com.portfolio.automation.questions.ui.TheUser;
import com.portfolio.automation.tasks.ui.ContinueAfterAccountCreation;
import com.portfolio.automation.tasks.ui.DeleteAccount;
import com.portfolio.automation.tasks.ui.GoToSignupLoginPage;
import com.portfolio.automation.tasks.ui.RegisterNewUser;
import com.portfolio.automation.ui.SignupLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class RegisterUserStepDefinitions {

    @When("they navigate to Signup Login")
    public void theyNavigateToSignupLogin() {
        theActorInTheSpotlight().attemptsTo(GoToSignupLoginPage.fromHome());
    }


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
                seeThat(TheAccount.wasCreated())
        );
    }

    @When("they continue after account creation")
    public void theyContinueAfterAccountCreation() {
        theActorInTheSpotlight().attemptsTo(
                ContinueAfterAccountCreation.now()
        );
    }

    @Then("they should be logged in")
    public void theyShouldBeLoggedIn() {
        theActorInTheSpotlight().should(
                seeThat(TheUser.isLoggedIn())
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
                seeThat(TheAccount.wasDeleted())
        );
    }
}
