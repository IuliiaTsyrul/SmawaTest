package com.intelias.model;

public enum Nettokreditbetrag {
    AMOUNT_2500("2.500"),
    AMOUNT_2750("2.750"),
    AMOUNT_3000("3.000");

    private String value;

    Nettokreditbetrag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}