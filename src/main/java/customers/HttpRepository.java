package customers;

import java.util.Optional;
import java.util.UUID;

class HttpRepository {

    void saveToDb(final Customer customer) {
        System.out.println("POST TO REST API");
    }

    Optional<Customer> getFromDb(final UUID id) {
        System.out.println("GET FROM REST API");
        return Optional.empty();
    }

    void method1() {

    }

    String method2() {
        return null;
    }
}
