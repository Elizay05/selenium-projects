package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.constants.ApiJsonKeys;
import com.portfolio.automation.tasks.api.DeleteUserAccount;
import com.portfolio.automation.tasks.api.DeleteUserAccountWithoutCredentials;
import com.portfolio.automation.tasks.api.DeleteUserAccountWithoutEmail;
import com.portfolio.automation.tasks.api.DeleteUserAccountWithoutPassword;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteUserAccountApiStepDefinitions {

    @When("they delete account with created credentials")
    public void theyDeleteAccountWithCreatedCredentials() {

        String email = theActorInTheSpotlight().recall(ApiJsonKeys.EMAIL);
        String password = theActorInTheSpotlight().recall(ApiJsonKeys.PASSWORD);

        theActorInTheSpotlight().attemptsTo(
                DeleteUserAccount.withCredentials(email, password)
        );
    }

    @When("they delete an account with email {string} and password {string}")
    public void theyDeleteAccountWithEmailAndPassword(String email, String password) {
        theActorInTheSpotlight().attemptsTo(
                DeleteUserAccount.withCredentials(email, password)
        );
    }

    @When("they delete an account without email")
    public void theyDeleteAnAccountWithoutEmail() {
        theActorInTheSpotlight().attemptsTo(
                DeleteUserAccountWithoutEmail.request()
        );
    }

    @When("they delete an account without password")
    public void theyDeleteAnAccountWithoutPassword() {
        theActorInTheSpotlight().attemptsTo(
                DeleteUserAccountWithoutPassword.request()
        );
    }

    @When("they delete an account without credentials")
    public void theyDeleteAnAccountWithoutCredentials() {
        theActorInTheSpotlight().attemptsTo(
                DeleteUserAccountWithoutCredentials.request()
        );
    }
}
