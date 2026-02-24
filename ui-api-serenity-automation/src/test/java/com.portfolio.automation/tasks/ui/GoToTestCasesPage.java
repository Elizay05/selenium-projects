package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class GoToTestCasesPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(HomePage.TEST_CASES_BUTTON));
    }

    public static GoToTestCasesPage fromHome() {
        return new GoToTestCasesPage();
    }
}
