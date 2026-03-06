package com.portfolio.automation.ui.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ProductDetailPage {
    private ProductDetailPage(){}

    public static final Target PRODUCT_NAME =
            Target.the("Product name")
                    .located(By.xpath("//div[@class='product-information']/h2"));

    public static final Target CATEGORY =
            Target.the("Category")
                    .located(By.xpath("//div[@class='product-information']/p[1]"));

    public static final Target PRICE =
            Target.the("Price")
                    .located(By.xpath("//div[@class='product-information']/span/span"));

    public static final Target AVAILABILITY =
            Target.the("Availability")
                    .located(By.xpath("//b[contains(text(),'Availability')]"));

    public static final Target CONDITION =
            Target.the("Condition")
                    .located(By.xpath("//b[contains(text(),'Condition')]"));

    public static final Target BRAND =
            Target.the("Brand")
                    .located(By.xpath("//b[contains(text(),'Brand')]"));
}
