package customers;

import java.util.Optional;
import java.util.UUID;

class RedisCache {

    void saveToCache(final Customer customer) {
        System.out.println("SAVED TO REDIS");
    }

    Optional<Customer> getFromCache(final UUID id) {
        System.out.println("RETRIEVED FROM REDIS");
        return Optional.empty();
    }

    void method1() {
    }

    String method2() {
        return null;
    }
}
