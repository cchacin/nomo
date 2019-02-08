package customers;

import com.example.app.cache.CustomerCache;
import com.example.app.domain.Customer;

import java.util.Optional;
import java.util.UUID;

public class MockCache implements CustomerCache {
    @Override
    public void saveToCache(Customer customer) {

    }

    @Override
    public Optional<Customer> getFromCache(UUID id) {
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
