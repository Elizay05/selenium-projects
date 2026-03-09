package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.components.BrandsComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BrandTitle implements Question<String> {

    public static BrandTitle text() {
        return new BrandTitle();
    }

    @Override
    public String answeredBy(Actor actor) {

        return BrandsComponent.BRAND_TITLE
                .resolveFor(actor)
                .getText()
                .trim()
                .toLowerCase();
    }
}
