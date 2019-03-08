package customers;

import java.util.Optional;
import java.util.UUID;

interface Cache {

    void saveToCache(
            final Customer customer);

    Optional<Customer> getFromCache(
            final UUID id);

    void method1();

    String method2();

}
