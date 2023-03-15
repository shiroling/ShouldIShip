package com.example.shouldship;

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
