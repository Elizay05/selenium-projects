package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.interactions.ui.SafeClick;
import com.portfolio.automation.ui.components.CategoriesComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SelectSubCategory implements Task {

    private final String category;
    private final String subCategory;

    public SelectSubCategory(String category, String subCategory) {
        this.category = category;
        this.subCategory = subCategory;
    }

    public static SelectSubCategory called(String category, String subCategory) {
        return Tasks.instrumented(SelectSubCategory.class, category, subCategory);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SafeClick.on(CategoriesComponent.SUBCATEGORY.of(category, subCategory))
        );
    }
}