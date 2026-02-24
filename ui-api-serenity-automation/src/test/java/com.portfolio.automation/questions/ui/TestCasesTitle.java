package com.portfolio.automation.questions.ui;

import com.portfolio.automation.ui.TestCasesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TestCasesTitle implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(TestCasesPage.TITLE).answeredBy(actor);
    }

    public static TestCasesTitle value() {
        return new TestCasesTitle();
    }
}
