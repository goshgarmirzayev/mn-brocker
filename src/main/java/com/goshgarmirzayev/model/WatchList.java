package com.goshgarmirzayev.model;

import java.util.ArrayList;
import java.util.List;

public class WatchList {
    private List<Symbol> symbols=new ArrayList<>();

    public WatchList() {
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public WatchList setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
        return this;
    }

    public WatchList(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return "WatchList{" +
                "symbols=" + symbols +
                '}';
    }
}
