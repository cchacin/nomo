package customers;

import java.util.Optional;
import java.util.UUID;

class HttpRepository {

    public void saveToDb(final Customer customer) {
        System.out.println("POST TO REST API");
    }

    public Optional<Customer> getFromDb(final UUID id) {
        System.out.println("GET FROM REST API");
        return Optional.empty();
    }

    public void method1() {

    }

    public String method2() {
        return null;
    }
}
