package com.portfolio.automation.ui.components;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class FooterComponent {

    private FooterComponent() {}

    public static final Target SUBSCRIPTION_TITLE =
            Target.the("Subscription title")
                    .located(By.xpath("//h2[text()='Subscription']"));

    public static final Target SUBSCRIPTION_EMAIL_INPUT =
            Target.the("Subscription email input")
                    .located(By.id("susbscribe_email"));

    public static final Target SUBSCRIPTION_BUTTON =
            Target.the("Subscription button")
                    .located(By.id("subscribe"));

    public static final Target SUBSCRIPTION_SUCCESS_MESSAGE =
            Target.the("Subscription success message")
                    .located(By.xpath("//div[@class='alert-success alert']"));
}
