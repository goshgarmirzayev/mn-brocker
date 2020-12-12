package com.goshgarmirzayev.controller;

import com.goshgarmirzayev.model.WatchList;
import com.goshgarmirzayev.store.InMemoryAccountStore;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import java.util.UUID;

@Controller("/account/watchlist")
public class WatchListController {
    private final InMemoryAccountStore memoryAccountStore;
    public static final UUID ACCOUNT_ID = UUID.randomUUID();

    public WatchListController(InMemoryAccountStore memoryAccountStore) {
        this.memoryAccountStore = memoryAccountStore;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public WatchList get() {
        return memoryAccountStore.getWatchList(ACCOUNT_ID);
    }

    @Put(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public WatchList updateWatchList(@Body WatchList watchList) {
        return memoryAccountStore.updateWatchList(ACCOUNT_ID, watchList);
    }
     @Delete(value = "/{accountId}",consumes = MediaType.APPLICATION_JSON,produces = MediaType.APPLICATION_JSON)
    public void delete(UUID accountId) {
        memoryAccountStore.deleteWatchList(accountId);
    }
}
