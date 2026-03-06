package com.portfolio.automation.utils;

public class PriceUtils {

    private PriceUtils(){}

    public static int extractPrice(String text) {
        return Integer.parseInt(
                text.replace("Rs.", "")
                        .replace("$", "")
                        .trim()
        );
    }
}
