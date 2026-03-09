package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.components.BrandsComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class OpenBrand implements Task {

    private final String brand;

    public OpenBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SafeClick.on(BrandsComponent.BRAND.of(brand))
        );
    }

    public static OpenBrand called(String brand) {
        return Tasks.instrumented(OpenBrand.class, brand);
    }
}
