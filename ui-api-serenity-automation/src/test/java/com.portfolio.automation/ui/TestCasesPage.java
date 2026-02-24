package com.portfolio.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class TestCasesPage {

    private TestCasesPage() {
    }

    public static final Target TITLE = Target.the("Test Cases page title")
            .locatedBy(".title.text-center");
}
