package com.example.shouldship.apiCalls;

public enum WeightUnit {
    GRAMS("g"),
    POUNDS("lb"),
    KILOGRAMS("kg"),
    TONNES("mt");

    private final String sign;

    WeightUnit(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
