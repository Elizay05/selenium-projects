package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.constants.ui.UiTexts;
import com.portfolio.automation.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToTestCasesPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        Task clickTestCases = Task.where(UiTexts.CLICK_TEST_CASES,
                WaitUntil.the(HomePage.TEST_CASES_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.TEST_CASES_BUTTON)
        );

        actor.attemptsTo(
                clickTestCases,
                HandleGoogleVignette.after(clickTestCases)
        );
    }

    public static GoToTestCasesPage fromHome() {
        return new GoToTestCasesPage();
    }
}