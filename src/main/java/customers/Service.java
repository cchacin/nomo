package customers;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

class Service {

    private final Repository repository;
    private final Cache cache;

    @Inject
    public Service(
            final Repository repository,
            final Cache cache) {
        this.repository = repository;
        this.cache = cache;
    }

    public void create(
            final Customer customer) {
        this.repository.saveToDb(customer);
        this.cache.saveToCache(customer);
    }

    public Optional<Customer> find(
            final UUID id) {
        final Optional<Customer> cachedCustomer = this.cache.getFromCache(id);
        if (cachedCustomer.isPresent()) {
            return cachedCustomer;
        } else {
            final Optional<Customer> dbCustomer = this.repository.getFromDb(id);
            if (dbCustomer.isPresent()) {
                this.cache.saveToCache(dbCustomer.get());
                return dbCustomer;
            }
        }
        return Optional.empty();
    }
}