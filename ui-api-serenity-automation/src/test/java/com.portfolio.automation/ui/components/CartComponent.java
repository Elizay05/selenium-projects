package com.portfolio.automation.ui.components;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CartComponent {

    private CartComponent(){}

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
}
