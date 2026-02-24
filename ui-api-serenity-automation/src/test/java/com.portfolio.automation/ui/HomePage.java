package com.portfolio.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    private HomePage() {
    }

    public static final String URL = "https://automationexercise.com/";

    public static final Target TEST_CASES_BUTTON = Target.the("Test Cases button")
            .locatedBy("a[href='/test_cases']");
}
