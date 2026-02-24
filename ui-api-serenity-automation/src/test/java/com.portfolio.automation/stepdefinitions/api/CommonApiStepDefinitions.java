package com.portfolio.automation.stepdefinitions.api;

import com.portfolio.automation.constants.api.ApiConstants;
import com.portfolio.automation.questions.api.ApiResponseCode;
import com.portfolio.automation.questions.api.ApiResponseMessage;
import com.portfolio.automation.questions.api.ProductsListSize;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class CommonApiStepDefinitions {
    @Before
    public void setUp() {
        RestAssured.defaultParser = Parser.JSON;
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user is connected to the API")
    public void theUserIsConnectedToTheAPI() {
        OnStage.theActorCalled("QA User")
                .can(CallAnApi.at(ApiConstants.BASE_URL));
    }

    @Then("the API response code should be {int}")
    public void theApiResponseCodeShouldBe(int expectedCode) {
        theActorInTheSpotlight().should(
                seeThat(ApiResponseCode.is(), equalTo(expectedCode))
        );
    }

    @And("the API response message should be {string}")
    public void theApiResponseMessageShouldBe(String expectedMessage) {
        theActorInTheSpotlight().should(
                seeThat(ApiResponseMessage.is(), equalTo(expectedMessage))
        );
    }

    @And("the products list should not be empty")
    public void theProductsListShouldNotBeEmpty() {
        theActorInTheSpotlight().should(
                seeThat(ProductsListSize.value(), greaterThan(0))
        );
    }
}
