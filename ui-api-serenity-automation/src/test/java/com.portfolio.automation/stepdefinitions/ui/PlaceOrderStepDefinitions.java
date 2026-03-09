package com.portfolio.automation.stepdefinitions.ui;

import com.portfolio.automation.constants.ui.UiRoutes;
import com.portfolio.automation.data.ui.UiTestData;
import com.portfolio.automation.models.ui.UiPaymentData;
import com.portfolio.automation.questions.ui.CurrentUrl;
import com.portfolio.automation.tasks.ui.ClickRegisterLogin;
import com.portfolio.automation.tasks.ui.ConfirmOrderInCheckout;
import com.portfolio.automation.tasks.ui.PayOrder;
import com.portfolio.automation.tasks.ui.ProceedToCheckout;
import com.portfolio.automation.ui.pages.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;

public class PlaceOrderStepDefinitions {

    @When("they proceed to checkout")
    public void theyProceedToCheckout() {
        theActorInTheSpotlight().attemptsTo(ProceedToCheckout.now());
    }

    @When("the checkout page should be visible")
    public void theCheckoutPageShouldBeVisible() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.current(), containsString(UiRoutes.CHECKOUT)));
        theActorInTheSpotlight().should(seeThat(the((CheckoutPage.COMMENT_BOX)), isVisible()));
    }

    @When("they choose to register or login")
    public void theyChooseToRegisterOrLogin() {
        theActorInTheSpotlight().attemptsTo(ClickRegisterLogin.now());
    }

    @When("they place the order")
    public void theyPlaceTheOrder() {
        theActorInTheSpotlight().attemptsTo(
                ConfirmOrderInCheckout.withComment(UiTestData.ORDER_COMMENT),
                PayOrder.with(UiPaymentData.defaultData())
        );
    }

    @Then("the order should be placed successfully")
    public void orderPlacedSuccessfully() {
        theActorInTheSpotlight().should(
                eventually(
                        seeThat(CurrentUrl.current(), containsString(UiRoutes.PAYMENT_DONE))
                )
        );
    }
}
