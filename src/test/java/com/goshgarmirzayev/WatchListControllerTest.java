package com.goshgarmirzayev;

import com.goshgarmirzayev.controller.WatchListController;
import com.goshgarmirzayev.model.Symbol;
import com.goshgarmirzayev.model.WatchList;
import com.goshgarmirzayev.store.InMemoryAccountStore;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@MicronautTest
public class WatchListControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WatchListControllerTest.class);
    private static final UUID TEST_ACCOUNT_ID = WatchListController.ACCOUNT_ID;
    @Inject
    InMemoryAccountStore inMemoryAccountStore;
    @Inject
    EmbeddedApplication embeddedApplication;
    @Inject
    @Client("/account/watchlist")
    RxHttpClient rxHttpClient;

    @Test
    public void testingEmptyWatchlist() {
        final WatchList result = rxHttpClient.toBlocking().retrieve(HttpRequest.GET("/"), WatchList.class);
        Assertions.assertTrue(inMemoryAccountStore.getWatchList(TEST_ACCOUNT_ID).getSymbols().isEmpty());
    }
    @Test
    void returnsWatchListPerAccount(){
       final List<Symbol> symbolList= Stream.of("APPL","AMZN","GOOGLE").map(Symbol::new).collect(Collectors.toList());
        WatchList watchList=new WatchList(symbolList);
        inMemoryAccountStore.updateWatchList(TEST_ACCOUNT_ID,watchList);
        final WatchList result = rxHttpClient.toBlocking().retrieve("/", WatchList.class);
        Assertions.assertEquals(3,result.getSymbols().size());
        Assertions.assertEquals(3,inMemoryAccountStore.getWatchList(TEST_ACCOUNT_ID).getSymbols().size());
    }
    @Test
    void canUpdateWatchListPerAccount(){
        final List<Symbol> symbolList= Stream.of("APPL","AMZN","GOOGLE").map(Symbol::new).collect(Collectors.toList());
        WatchList watchList=new WatchList(symbolList);
        final HttpResponse<Object> response=rxHttpClient.toBlocking().exchange(HttpRequest.PUT("/",watchList));
        Assertions.assertEquals(HttpStatus.OK,response.status());
//        Assertions.assertEquals(watchList,inMemoryAccountStore.getWatchList(TEST_ACCOUNT_ID));
    }
    @Test
    void canDeleteWatchList(){
        final List<Symbol> symbolList= Stream.of("APPL","AMZN","GOOGLE").map(Symbol::new).collect(Collectors.toList());
        WatchList watchList=new WatchList(symbolList);
        inMemoryAccountStore.updateWatchList(TEST_ACCOUNT_ID,watchList);
        Assertions.assertFalse(inMemoryAccountStore.getWatchList(TEST_ACCOUNT_ID).getSymbols().isEmpty());

        final HttpResponse<Object> response= rxHttpClient.toBlocking().exchange(HttpRequest.DELETE("/"+TEST_ACCOUNT_ID));
        Assertions.assertEquals(HttpStatus.OK,response.status());
        Assertions.assertTrue(inMemoryAccountStore.getWatchList(TEST_ACCOUNT_ID).getSymbols().isEmpty());
    }
}
