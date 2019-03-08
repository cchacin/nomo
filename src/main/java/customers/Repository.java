package customers;

import java.util.Optional;
import java.util.UUID;

interface Repository {

    void saveToDb(
            final Customer customer);

    Optional<Customer> getFromDb(
            final UUID id);

    void method1();

    String method2();
}
