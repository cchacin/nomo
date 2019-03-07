package customers;

import java.util.Optional;
import java.util.UUID;

public class MockCache implements CustomerCache {
    @Override
    public void saveToCache(Customer customer) {

    }

    @Override
    public Optional<Customer> getFromCache(UUID id) {
        System.out.println("GETTING FROM MOCK CACHE");
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
