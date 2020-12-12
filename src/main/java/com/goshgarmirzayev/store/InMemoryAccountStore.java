package com.goshgarmirzayev.store;

import com.goshgarmirzayev.model.WatchList;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.UUID;

@Singleton
public class InMemoryAccountStore {
    private final HashMap<UUID, WatchList> watchListPerAccount = new HashMap<>();

    public WatchList getWatchList(UUID accountId) {
        return watchListPerAccount.getOrDefault(accountId, new WatchList());
    }

    public WatchList updateWatchList(UUID randomUUID, final WatchList watchList) {
        watchListPerAccount.put(randomUUID, watchList);
        return getWatchList(randomUUID);
    }

    public void deleteWatchList(final UUID accountId) {
        watchListPerAccount.remove(accountId);
    }
}
