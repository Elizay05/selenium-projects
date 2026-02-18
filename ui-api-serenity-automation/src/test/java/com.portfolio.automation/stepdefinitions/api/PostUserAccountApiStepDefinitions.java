package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.data.UserTestDataBuilder;
import com.portfolio.automation.models.CreateUserRequest;
import com.portfolio.automation.tasks.api.PostUserAccount;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostUserAccountApiStepDefinitions {

    @When("they create a new account")
    public void theyCreateANewAccount() {
        CreateUserRequest request = UserTestDataBuilder
                .aUser()
                .build();
        theActorInTheSpotlight().attemptsTo(PostUserAccount.withData(request));
    }

    @When("they create an account with an existing email")
    public void theyCreateAnAccountWithAnExistingEmail() {
        CreateUserRequest request = UserTestDataBuilder
                .aUser()
                .build();

        theActorInTheSpotlight().attemptsTo(
                PostUserAccount.withData(request)
        );

        theActorInTheSpotlight().attemptsTo(
                PostUserAccount.withData(request)
        );
    }

    @When("they create an account without name")
    public void theyCreateAnAccountWithoutName() {
        CreateUserRequest request = UserTestDataBuilder
                .aUser()
                .withName(null)
                .build();

        theActorInTheSpotlight().attemptsTo(
                PostUserAccount.withData(request)
        );
    }

    @When("they create an account without email")
    public void theyCreateAnAccountWithoutEmail() {
        CreateUserRequest request = UserTestDataBuilder
                .aUser()
                .withEmail(null)
                .build();

        theActorInTheSpotlight().attemptsTo(
                PostUserAccount.withData(request)
        );
    }

    @When("they create an account without password")
    public void theyCreateAnAccountWithoutPassword() {
        CreateUserRequest request = UserTestDataBuilder
                .aUser()
                .withPassword(null)
                .build();

        theActorInTheSpotlight().attemptsTo(
                PostUserAccount.withData(request)
        );
    }

    @When("they create an account without body")
    public void theyCreateAnAccountWithoutBody() {
        CreateUserRequest emptyRequest = new CreateUserRequest();

        theActorInTheSpotlight().attemptsTo(
                PostUserAccount.withData(emptyRequest)
        );
    }
}
