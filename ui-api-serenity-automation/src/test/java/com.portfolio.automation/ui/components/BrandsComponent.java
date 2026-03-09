package com.portfolio.automation.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class BrandsComponent {

    public static final Target BRAND =
            Target.the("Brand link")
                    .locatedBy("//div[@class='brands_products']//a[contains(.,'{0}')]");

    public static final Target BRAND_TITLE =
            Target.the("Brand title")
                    .locatedBy(".title.text-center");
}
