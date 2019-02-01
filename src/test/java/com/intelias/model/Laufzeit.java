package com.intelias.model;

public enum Laufzeit {
    MONTH84("84 Monate"),
    MONTH24("24 Monate");

    private String value;

    Laufzeit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}