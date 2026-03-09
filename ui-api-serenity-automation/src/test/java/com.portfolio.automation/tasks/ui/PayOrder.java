package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.models.ui.UiPaymentData;
import com.portfolio.automation.ui.pages.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

public class PayOrder implements Task {

    private final UiPaymentData data;

    public PayOrder(UiPaymentData data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Enter.theValue(data.getNameOnCard())
                        .into(PaymentPage.NAME_ON_CARD),

                Enter.theValue(data.getCardNumber())
                        .into(PaymentPage.CARD_NUMBER),

                Enter.theValue(data.getCvc())
                        .into(PaymentPage.CVC),

                Enter.theValue(data.getExpMonth())
                        .into(PaymentPage.EXP_MONTH),

                Enter.theValue(data.getExpYear())
                        .into(PaymentPage.EXP_YEAR),

                Scroll.to(PaymentPage.PAY_CONFIRM_BUTTON),
                SafeClick.on(PaymentPage.PAY_CONFIRM_BUTTON)
        );
    }

    public static PayOrder with(UiPaymentData data) {
        return Tasks.instrumented(PayOrder.class, data);
    }
}
