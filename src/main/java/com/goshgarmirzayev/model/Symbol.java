package com.goshgarmirzayev.model;

public class Symbol {


    private String value;

    public Symbol(String value) {
        this.value = value;
    }

    public Symbol() {
    }

    public String getValue() {
        return value;
    }

    public Symbol setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "value='" + value + '\'' +
                '}';
    }
}
