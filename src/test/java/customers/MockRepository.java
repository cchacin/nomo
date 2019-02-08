package customers;

import com.example.app.domain.Customer;
import com.example.app.repository.CustomerRepository;

import java.util.Optional;
import java.util.UUID;

public class MockRepository implements CustomerRepository {
    @Override
    public void saveToDb(Customer customer) {

    }

    @Override
    public Optional<Customer> getFromDb(UUID id) {
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
