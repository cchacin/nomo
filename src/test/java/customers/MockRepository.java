package customers;

import java.util.Optional;
import java.util.UUID;

public class MockRepository implements Repository {
    @Override
    public void saveToDb(Customer customer) {

    }

    @Override
    public Optional<Customer> getFromDb(UUID id) {
        System.out.println("GETTING FROM MOCK REPOSITORY");
        return Optional.empty();
    }

    @Override
    public void method1() {

    }

    @Override
    public String method2() {
        return null;
    }
}
