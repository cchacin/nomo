package customers;

public interface AppFactory {

    static CustomerEndpoint endpoint() {
        var dbRepository = new DbRepository();
        var fileSystemCache = new FileSystemCache();
        return new CustomerEndpoint(
                new Service(
                        fileSystemCache::getFromCache,
                        dbRepository::getFromDb,
                        dbRepository::saveToDb,
                        fileSystemCache::saveToCache
                )
        );
    }
}
