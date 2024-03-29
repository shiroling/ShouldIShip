package com.example.shouldship.apiCalls;

public enum DistanceUnit {
    MILES("mi"),
    KILOMETERS("km");

    private final String sign;

    DistanceUnit(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
