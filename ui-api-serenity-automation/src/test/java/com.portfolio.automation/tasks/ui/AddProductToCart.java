package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.ui.pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AddProductToCart implements Task {

    private final Target product;
    private final Target addButton;

    public AddProductToCart(Target product, Target addButton) {
        this.product = product;
        this.addButton = addButton;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(addButton),
                WaitUntil.the(addButton, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(addButton)
        );
    }

    public static AddProductToCart firstProduct() {
        return Tasks.instrumented(
                AddProductToCart.class,
                ProductsPage.FIRST_PRODUCT,
                ProductsPage.FIRST_ADD_TO_CART
        );
    }

    public static AddProductToCart secondProduct() {
        return Tasks.instrumented(
                AddProductToCart.class,
                ProductsPage.SECOND_PRODUCT,
                ProductsPage.SECOND_ADD_TO_CART
        );
    }
}
