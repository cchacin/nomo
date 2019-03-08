package customers;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

class Service {

    private final Function<UUID, Optional<Customer>> getFromCache;
    private final Function<UUID, Optional<Customer>> getFromDb;
    private final Consumer<Customer> saveToDb;
    private final Consumer<Customer> saveToCache;

    @Inject
    Service(Function<UUID, Optional<Customer>> getFromCache,
            Function<UUID, Optional<Customer>> getFromDb,
            Consumer<Customer> saveToDb,
            Consumer<Customer> saveToCache) {
        this.getFromCache = getFromCache;
        this.getFromDb = getFromDb;
        this.saveToDb = saveToDb;
        this.saveToCache = saveToCache;
    }

    public void create(
            final Customer customer) {
        this.saveToDb.accept(customer);
        this.saveToCache.accept(customer);
    }

    public Optional<Customer> find(
            final UUID id) {
        final Optional<Customer> cachedCustomer = this.getFromCache.apply(id);
        if (cachedCustomer.isPresent()) {
            return cachedCustomer;
        } else {
            final Optional<Customer> dbCustomer = this.getFromDb.apply(id);
            if (dbCustomer.isPresent()) {
                this.saveToCache.accept(dbCustomer.get());
                return dbCustomer;
            }
        }
        return Optional.empty();
    }
}
