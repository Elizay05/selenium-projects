package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.models.ui.UiContactData;
import com.portfolio.automation.ui.pages.ContactUsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillContactForm implements Task {

    private final UiContactData data;

    public FillContactForm(UiContactData data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        actor.attemptsTo(
                WaitUntil.the(ContactUsPage.GET_IN_TOUCH_TITLE, isVisible())
                        .forNoMoreThan(5).seconds(),

                Enter.theValue(data.getName()).into(ContactUsPage.NAME),
                Enter.theValue(data.getEmail()).into(ContactUsPage.EMAIL),
                Enter.theValue(data.getSubject()).into(ContactUsPage.SUBJECT),
                Enter.theValue(data.getMessage()).into(ContactUsPage.MESSAGE),

                Upload.theFile(Paths.get(data.getFilePath()))
                        .to(ContactUsPage.UPLOAD_FILE),

                Click.on(ContactUsPage.SUBMIT_BUTTON)
        );

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }

    public static FillContactForm with(UiContactData data) {
        return Tasks.instrumented(FillContactForm.class, data);
    }
}
