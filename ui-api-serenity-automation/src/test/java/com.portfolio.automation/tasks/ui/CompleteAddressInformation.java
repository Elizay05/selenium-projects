package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.data.ui.UiRegistrationData;
import com.portfolio.automation.ui.AccountInfoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteAddressInformation implements Task {

    private final UiRegistrationData data;

    public CompleteAddressInformation(UiRegistrationData data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(data.getFirstName()).into(AccountInfoPage.FIRST_NAME),
                Enter.theValue(data.getLastName()).into(AccountInfoPage.LAST_NAME),
                Enter.theValue(data.getCompany()).into(AccountInfoPage.COMPANY),
                Enter.theValue(data.getAddress1()).into(AccountInfoPage.ADDRESS1),
                Enter.theValue(data.getAddress2()).into(AccountInfoPage.ADDRESS2),
                SelectFromOptions.byVisibleText(data.getCountry()).from(AccountInfoPage.COUNTRY),
                Enter.theValue(data.getState()).into(AccountInfoPage.STATE),
                Enter.theValue(data.getCity()).into(AccountInfoPage.CITY),
                Enter.theValue(data.getZipcode()).into(AccountInfoPage.ZIPCODE),
                Enter.theValue(data.getMobileNumber()).into(AccountInfoPage.MOBILE)
        );
    }

    public static CompleteAddressInformation with(UiRegistrationData data) {
        return Tasks.instrumented(CompleteAddressInformation.class, data);
    }
}
