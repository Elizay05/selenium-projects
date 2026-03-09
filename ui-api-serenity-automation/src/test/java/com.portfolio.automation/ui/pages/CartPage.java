package com.portfolio.automation.ui.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    private CartPage(){}

    public static final Target CART_SECTION = Target.the("Cart section")
            .located(By.id("cart_items"));

    public static final Target CART_PRODUCTS =
            Target.the("Products in cart")
                    .located(By.cssSelector(".cart_info tbody tr"));

    public static final Target PRODUCT_NAME =
            Target.the("Product name")
                    .located(By.cssSelector(".cart_description h4 a"));

    public static final Target PRODUCT_PRICE =
            Target.the("Product price")
                    .located(By.cssSelector(".cart_price p"));

    public static final Target PRODUCT_QUANTITY =
            Target.the("Product quantity")
                    .located(By.cssSelector(".cart_quantity button"));

    public static final Target PRODUCT_TOTAL =
            Target.the("Product total")
                    .located(By.cssSelector(".cart_total_price"));

    public static final Target PROCEED_TO_CHECKOUT_BUTTON =
            Target.the("Proceed to checkout button")
                    .located(By.cssSelector(".check_out"));

    public static final Target REMOVE_PRODUCT_BUTTON_BY_NAME =
            Target.the("Remove button for product {0}")
                    .locatedBy("//td[@class='cart_description']//a[text()='{0}']/ancestor::tr//a[@class='cart_quantity_delete']");

}
