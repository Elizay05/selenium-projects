package com.portfolio.automation.utils;

import java.util.HashMap;
import java.util.Map;

public class ParamsBuilder {
    private final Map<String, Object> params = new HashMap<>();

    private ParamsBuilder(String key, Object value) {
        putIfNotNull(key, value);
    }

    public static ParamsBuilder with(String key, Object value) {
        return new ParamsBuilder(key, value);
    }

    public ParamsBuilder and(String key, Object value) {
        putIfNotNull(key, value);
        return this;
    }

    public Map<String, Object> build() {
        return params;
    }

    private void putIfNotNull(String key, Object value) {
        if (value != null) {
            params.put(key, value);
        }
    }
}
