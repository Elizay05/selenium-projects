package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToTestCasesPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.TEST_CASES_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
                SafeClick.on(HomePage.TEST_CASES_BUTTON)
        );
    }

    public static GoToTestCasesPage fromHome() {
        return Tasks.instrumented(GoToTestCasesPage.class);
    }
}