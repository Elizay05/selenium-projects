package com.portfolio.automation.ui.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {
    private ProductsPage(){}

    public static final Target PRODUCTS_BUTTON =
            Target.the("Products button")
                    .located(By.xpath("//a[@href='/products']"));

    public static final Target PRODUCTS_LIST =
            Target.the("Products list")
                    .located(By.className("features_items"));

    public static final Target ALL_PRODUCTS_TITLE =
            Target.the("All products title")
                    .located(By.xpath("//h2[contains(text(),'All Products')]"));

    public static final Target FIRST_VIEW_PRODUCT =
            Target.the("First view product button")
                    .located(By.xpath("(//a[contains(@href,'product_details')])[1]"));

    public static final Target SEARCH_INPUT =
            Target.the("Search product input")
                    .located(By.id("search_product"));

    public static final Target SEARCH_BUTTON =
            Target.the("Search button")
                    .located(By.id("submit_search"));

    public static final Target SEARCHED_PRODUCTS_TITLE =
            Target.the("Searched products title")
                    .located(By.xpath("//h2[contains(text(),'Searched Products')]"));

    public static final Target PRODUCT_LIST =
            Target.the("Product list")
                    .located(By.xpath("//div[@class='product-image-wrapper']"));

    public static final Target ADD_TO_CART_BUTTON_BY_NAME =
            Target.the("Add to cart button for product {0}")
                    .locatedBy("//p[text()='{0}']/ancestor::div[@class='productinfo text-center']//a[contains(@class,'add-to-cart')]");

    public static final Target CONTINUE_SHOPPING_BUTTON =
            Target.the("Continue shopping button")
                    .located(By.xpath("//button[text()='Continue Shopping']"));

    public static final Target PRODUCT_CARDS =
            Target.the("Product cards")
                    .locatedBy(".product-image-wrapper");
}
