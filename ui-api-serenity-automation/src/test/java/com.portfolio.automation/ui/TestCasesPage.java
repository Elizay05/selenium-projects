package com.portfolio.automation.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class TestCasesPage {

    private TestCasesPage() {
    }
    public static final Target TITLE = Target.the("Test Cases page title")
            .located(By.xpath("//h2[@class='title text-center']/b"));
}
