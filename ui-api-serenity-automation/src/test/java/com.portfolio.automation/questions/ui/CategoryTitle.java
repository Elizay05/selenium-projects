package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.components.CategoriesComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CategoryTitle implements Question<String> {

    public static CategoryTitle text() {
        return new CategoryTitle();
    }

    @Override
    public String answeredBy(Actor actor) {
        return CategoriesComponent.CATEGORY_TITLE
                .resolveFor(actor)
                .getText()
                .trim()
                .toLowerCase();
    }
}
