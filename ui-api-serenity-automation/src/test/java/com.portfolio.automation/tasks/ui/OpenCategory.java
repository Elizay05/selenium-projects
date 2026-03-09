package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.components.CategoriesComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class OpenCategory implements Task {

    private final String category;

    public OpenCategory(String category) {
        this.category = category;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SafeClick.on(CategoriesComponent.CATEGORY.of(category))
        );
    }

    public static OpenCategory called(String category) {
        return Tasks.instrumented(OpenCategory.class, category);
    }
}
