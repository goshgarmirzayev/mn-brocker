package com.goshgarmirzayev.model;


import java.io.Serializable;
import java.math.BigDecimal;

public class Quote  implements Serializable {
    private Symbol symbol;
    private BigDecimal bid;
    private BigDecimal ask;
    private BigDecimal lastPrice;
    private BigDecimal volume;

    public Quote(Symbol symbol, BigDecimal bid, BigDecimal ask, BigDecimal lastPrice, BigDecimal volume) {
        this.symbol = symbol;
        this.bid = bid;
        this.ask = ask;
        this.lastPrice = lastPrice;
        this.volume = volume;
    }

    public Quote() {
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Quote setSymbol(Symbol symbol) {
        this.symbol = symbol;
        return this;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public Quote setBid(BigDecimal bid) {
        this.bid = bid;
        return this;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public Quote setAsk(BigDecimal ask) {
        this.ask = ask;
        return this;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public Quote setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
        return this;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public Quote setVolume(BigDecimal volume) {
        this.volume = volume;
        return this;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "symbol=" + symbol +
                ", bid=" + bid +
                ", ask=" + ask +
                ", lastPrice=" + lastPrice +
                ", volume=" + volume +
                '}';
    }
}
