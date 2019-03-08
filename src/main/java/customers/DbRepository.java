package customers;

import java.util.Optional;
import java.util.UUID;

class DbRepository {

    public void saveToDb(Customer customer) {
        System.out.println("SAVED TO DATABASE");
    }

    public Optional<Customer> getFromDb(UUID id) {
        System.out.println("RETRIVED FROM DATABASE");
        return Optional.empty();
    }

    public void method1() {
    }

    public String method2() {
        return null;
    }
}
