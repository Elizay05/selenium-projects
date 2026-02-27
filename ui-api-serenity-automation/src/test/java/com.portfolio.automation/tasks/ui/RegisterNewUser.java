package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.data.ui.UiRegistrationData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class RegisterNewUser implements Task {

    private final UiRegistrationData data;

    public RegisterNewUser(UiRegistrationData data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                CompleteSignupForm.with(data),
                CompleteAccountInformation.with(data),
                CompleteAddressInformation.with(data),
                CreateAccount.now()
        );
    }

    public static RegisterNewUser withDefaultData() {
        return Tasks.instrumented(RegisterNewUser.class, UiRegistrationData.defaultData());
    }
}
