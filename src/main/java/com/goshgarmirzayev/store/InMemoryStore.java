package com.goshgarmirzayev.store;

import com.goshgarmirzayev.model.Quote;
import com.goshgarmirzayev.model.Symbol;

import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
public class InMemoryStore {
    private final List<Symbol> symbols;
    private final ThreadLocalRandom current = ThreadLocalRandom.current();

    public InMemoryStore(List<Symbol> symbols) {
        this.symbols = Stream.of("Google", "Amazon", "Tesla").
                map(Symbol::new).collect(Collectors.toList());
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public Quote fetchQuote(String symbol) {
        return new Quote()
                .setSymbol(new Symbol(symbol))
                .setAsk(randomValue())
                .setBid(randomValue())
                .setLastPrice(randomValue())
                .setVolume(randomValue());
    }

    public BigDecimal randomValue() {

        return BigDecimal.valueOf(current.nextDouble(1, 100));
    }
}
