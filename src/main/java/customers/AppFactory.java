package customers;

public interface AppFactory {

    static CustomerEndpoint endpoint() {
        var dbRepository = new DbRepository();
        var fileSystemCache = new FileSystemCache();
        var service = new Service(
                fileSystemCache::getFromCache,
                dbRepository::getFromDb,
                dbRepository::saveToDb,
                fileSystemCache::saveToCache
        );
        return new CustomerEndpoint(
                service::find,
                service::create
        );
    }
}
