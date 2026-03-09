package com.portfolio.automation.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class CategoriesComponent {

    public static final Target CATEGORY =
            Target.the("Category")
                    .locatedBy("//a[contains(.,'{0}')]");

    public static final Target SUBCATEGORY =
            Target.the("Subcategory")
                    .locatedBy("//div[@id='{0}']//a[contains(.,'{1}')]");

    public static final Target CATEGORY_TITLE =
            Target.the("Category title")
                    .locatedBy(".title.text-center");
}
