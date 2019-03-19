package customers;

import java.util.Optional;
import java.util.UUID;

class DbRepository {

    void saveToDb(final Customer customer) {
        System.out.println("SAVED TO DATABASE");
    }

    Optional<Customer> getFromDb(final UUID id) {
        System.out.println("RETRIVED FROM DATABASE");
        return Optional.empty();
    }

    void method1() {
    }

    String method2() {
        return null;
    }
}
