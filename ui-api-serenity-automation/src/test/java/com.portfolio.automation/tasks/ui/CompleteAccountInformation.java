package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.data.ui.UiRegistrationData;
import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.AccountInfoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.CheckCheckbox;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteAccountInformation implements Task {

    private final UiRegistrationData data;

    public CompleteAccountInformation(UiRegistrationData data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AccountInfoPage.ENTER_ACCOUNT_INFORMATION_TITLE, isVisible())
                        .forNoMoreThan(10).seconds(),

                SafeClick.on(AccountInfoPage.TITLE_MRS),
                Enter.theValue(data.getPassword()).into(AccountInfoPage.PASSWORD),
                SelectFromOptions.byValue(data.getDay()).from(AccountInfoPage.DAY),
                SelectFromOptions.byValue(data.getMonth()).from(AccountInfoPage.MONTH),
                SelectFromOptions.byValue(data.getYear()).from(AccountInfoPage.YEAR),
                CheckCheckbox.of(AccountInfoPage.NEWSLETTER),
                CheckCheckbox.of(AccountInfoPage.OFFERS)
        );
    }

    public static CompleteAccountInformation with(UiRegistrationData data) {
        return Tasks.instrumented(CompleteAccountInformation.class, data);
    }
}
