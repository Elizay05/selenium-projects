package com.portfolio.automation.ui.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaymentPage {

    private PaymentPage(){}

    public static final Target NAME_ON_CARD =
            Target.the("Name on card")
                    .located(By.name("name_on_card"));

    public static final Target CARD_NUMBER =
            Target.the("Card number")
                    .located(By.name("card_number"));

    public static final Target CVC =
            Target.the("CVC")
                    .located(By.name("cvc"));

    public static final Target EXP_MONTH =
            Target.the("Expiration month")
                    .located(By.name("expiry_month"));

    public static final Target EXP_YEAR =
            Target.the("Expiration year")
                    .located(By.name("expiry_year"));

    public static final Target PAY_CONFIRM_BUTTON =
            Target.the("Pay and confirm order")
                    .located(By.id("submit"));
}
