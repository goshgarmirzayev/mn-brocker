package com.goshgarmirzayev;

import com.goshgarmirzayev.model.Quote;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@MicronautTest
public class QuotesControllerTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuotesControllerTests.class);
    @Inject
    @Client("/")
    RxHttpClient rxHttpClient;
    @Inject
    EmbeddedApplication embeddedApplication;

    @Test
    void returnQuotesSymbols() {
        final Quote appleResult = rxHttpClient.toBlocking().retrieve(HttpRequest.GET("/quotes/APPL"), Quote.class);
        LOGGER.info("Result :{}", appleResult);
    }

}
