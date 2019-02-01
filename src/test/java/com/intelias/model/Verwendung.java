package com.intelias.model;

public enum Verwendung {
    WOHNEN("Wohnen"),
    GEWERBE("Gewerbe"),
    FREIEVWEWENDUNG("Freie Verwendung");

    private String value;

    Verwendung(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}





