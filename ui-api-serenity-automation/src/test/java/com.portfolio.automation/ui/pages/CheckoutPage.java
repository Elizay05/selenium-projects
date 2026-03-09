package com.portfolio.automation.ui.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    private CheckoutPage(){}

    public static final Target REGISTER_LOGIN_BUTTON =
            Target.the("Register login button")
                    .located(By.xpath("//u[text()='Register / Login']"));

    public static final Target COMMENT_BOX =
            Target.the("Order comment")
                    .located(By.name("message"));

    public static final Target PLACE_ORDER_BUTTON =
            Target.the("Place order button")
                    .located(By.xpath("//a[contains(text(),'Place Order')]"));
}
