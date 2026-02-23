package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.constants.ApiJsonKeys;
import com.portfolio.automation.questions.api.UserEmail;
import com.portfolio.automation.tasks.api.GetUserDetailByEmail;
import com.portfolio.automation.utils.ParamsBuilder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class GetUserAccountApiStepDefinitions {

    @When("they request user detail by created email")
    public void theyRequestUserDetailByCreatedEmail() {
        Map<String, Object> params = ParamsBuilder
                .with(ApiJsonKeys.EMAIL, theActorInTheSpotlight().recall(ApiJsonKeys.EMAIL))
                .build();

        theActorInTheSpotlight().attemptsTo(
                GetUserDetailByEmail.withEmail(params)
        );
    }

    @And("the response should contain the correct user email")
    public void shouldContainCorrectEmail() {
        String expectedEmail = theActorInTheSpotlight().recall(ApiJsonKeys.EMAIL);

        theActorInTheSpotlight().should(
                seeThat(UserEmail.value(), equalTo(expectedEmail))
        );
    }

    @When("they request user detail with email {string}")
    public void theyRequestUserDetailWithEmail(String email) {
        Map<String, Object> params = ParamsBuilder
                .with(ApiJsonKeys.EMAIL, email)
                .build();

        theActorInTheSpotlight().attemptsTo(
                GetUserDetailByEmail.withEmail(params)
        );
    }

    @When("they request user detail without email")
    public void theyRequestUserDetailWithoutEmail() {
        theActorInTheSpotlight().attemptsTo(
                GetUserDetailByEmail.withEmail(new HashMap<>())
        );
    }
}
