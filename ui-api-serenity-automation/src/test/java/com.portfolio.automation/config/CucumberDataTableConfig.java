package com.portfolio.automation.config;

import com.portfolio.automation.models.ui.UiExpectedProduct;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CucumberDataTableConfig {

    @DataTableType
    public UiExpectedProduct uiExpectedProductEntry(Map<String, String> entry) {

        return new UiExpectedProduct(
                entry.get("Product").trim(),
                Integer.parseInt(entry.get("Price").trim()),
                Integer.parseInt(entry.get("Qty").trim()),
                Integer.parseInt(entry.get("Total").trim())
        );
    }
}
