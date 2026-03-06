package com.portfolio.automation.ui.pages;

import com.portfolio.automation.constants.ui.UiConstants;
import com.portfolio.automation.constants.ui.UiRoutes;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    private HomePage() {
    }

    public static final String URL = UiConstants.BASE_URL + "/";

    public static final Target TEST_CASES_BUTTON = Target.the("Test Cases button")
            .locatedBy("//a[@href='" + UiRoutes.TEST_CASES + "']");

    public static final Target SIGNUP_LOGIN_BUTTON = Target.the("Signup/Login button")
            .locatedBy("//a[@href='" + UiRoutes.SIGNUP_LOGIN + "']");

    public static final Target CONTACT_US_BUTTON = Target.the("Contact Us button")
            .locatedBy("//a[@href='" + UiRoutes.CONTACT_US + "']");

    public static final Target CART_BUTTON = Target.the("Cart button")
            .locatedBy("//a[@href='/view_cart']");
}
