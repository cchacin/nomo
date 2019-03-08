package customers;

import java.util.Optional;
import java.util.UUID;

class RedisCache {

    public void saveToCache(final Customer customer) {
        System.out.println("SAVED TO REDIS");
    }

    public Optional<Customer> getFromCache(final UUID id) {
        System.out.println("RETRIEVED FROM REDIS");
        return Optional.empty();
    }

    public void method1() {
    }

    public String method2() {
        return null;
    }
}
