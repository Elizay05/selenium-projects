package com.portfolio.automation.tasks.ui;

import com.portfolio.automation.questions.ui.CartProductCount;
import com.portfolio.automation.ui.pages.CartPage;
import com.portfolio.automation.ui.pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ManageCart implements Task {

    public enum Action {
        ADD,
        REMOVE
    }

    private final Action action;
    private final List<String> products;

    public ManageCart(Action action, List<String> products) {
        this.action = action;
        this.products = products;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch (action) {

            case ADD:

                for (String product : products) {

                    Target addButton = ProductsPage.ADD_TO_CART_BUTTON_BY_NAME.of(product);

                    actor.attemptsTo(
                            Scroll.to(addButton),
                            WaitUntil.the(addButton, WebElementStateMatchers.isClickable())
                                    .forNoMoreThan(5).seconds(),
                            Click.on(addButton),
                            Click.on(ProductsPage.CONTINUE_SHOPPING_BUTTON)
                    );
                }

                break;

            case REMOVE:

                for (String product : products) {

                    int initialProducts = CartPage.CART_PRODUCTS.resolveAllFor(actor).size();

                    Target removeButton = CartPage.REMOVE_PRODUCT_BUTTON_BY_NAME.of(product);

                    actor.attemptsTo(
                            Scroll.to(removeButton),
                            WaitUntil.the(removeButton, WebElementStateMatchers.isClickable())
                                    .forNoMoreThan(5).seconds(),
                            Click.on(removeButton)
                    );

                    actor.should(
                            eventually(seeThat(CartProductCount.value(), equalTo(initialProducts - 1)))
                    );
                }

                break;
        }
    }

    public static ManageCart addProducts(List<String> products) {
        return Tasks.instrumented(ManageCart.class, Action.ADD, products);
    }

    public static ManageCart removeProducts(List<String> products) {
        return Tasks.instrumented(ManageCart.class, Action.REMOVE, products);
    }
}