package customers;

import javax.inject.Inject;
import java.util.Optional;
import java.util.UUID;

public class CustomerEndpoint {

    private final Service service;

    @Inject
    public CustomerEndpoint(
            final Service service) {
        this.service = service;
    }

    public void create(
            Customer customer) {
        service.create(customer);
    }

    public Optional<Customer> find(
            UUID id) {
        return service.find(id);
    }
}
