package com.goshgarmirzayev.controller;

import com.goshgarmirzayev.model.Symbol;
import com.goshgarmirzayev.store.InMemoryStore;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/markets")
public class MarketsController {
    private final InMemoryStore inMemoryStore;

    public MarketsController(InMemoryStore inMemoryStore) {
        this.inMemoryStore = inMemoryStore;
    }

    @Get(value = "/")
    public List<Symbol> all() {
        return inMemoryStore.getSymbols();
    }
}
