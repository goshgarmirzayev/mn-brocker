package com.goshgarmirzayev.controller;

import com.goshgarmirzayev.model.Quote;
import com.goshgarmirzayev.store.InMemoryStore;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/quotes")
public class QuotesController {

    private final InMemoryStore inMemoryStore;

    public QuotesController(InMemoryStore inMemoryStore) {
        this.inMemoryStore = inMemoryStore;
    }

    @Get(value = "/{symbol}")
    public HttpResponse getQuote(String symbol) {
        Quote quote = inMemoryStore.fetchQuote(symbol);
        return HttpResponse.ok(quote);
    }
}

