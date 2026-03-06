package com.portfolio.automation.ui.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ContactUsPage {

    public static final Target GET_IN_TOUCH_TITLE =
            Target.the("get in touch title")
                    .located(By.xpath("//*[contains(text(),'Get In Touch')]"));

    public static final Target NAME =
            Target.the("name input")
                    .located(By.name("name"));

    public static final Target EMAIL =
            Target.the("email input")
                    .located(By.name("email"));

    public static final Target SUBJECT =
            Target.the("subject input")
                    .located(By.name("subject"));

    public static final Target MESSAGE =
            Target.the("message textarea")
                    .located(By.name("message"));

    public static final Target UPLOAD_FILE =
            Target.the("upload file input")
                    .located(By.name("upload_file"));

    public static final Target SUBMIT_BUTTON =
            Target.the("submit button")
                    .located(By.name("submit"));

    public static final Target SUCCESS_MESSAGE =
            Target.the("success message")
                    .located(By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]"));

    public static final Target HOME_BUTTON =
            Target.the("home button")
                    .located(By.xpath("//a[@class='btn btn-success']"));
}
