package customers;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

public class CustomerEndpoint {

    private final Function<UUID, Optional<Customer>> getCustomer;
    private final Consumer<Customer> saveCustomer;

    public CustomerEndpoint(
            final Function<UUID, Optional<Customer>> getCustomer,
            final Consumer<Customer> saveCustomer) {
        this.getCustomer = getCustomer;
        this.saveCustomer = saveCustomer;
    }


    public void create(
            final Customer customer) {
        this.saveCustomer.accept(customer);
    }

    public Optional<Customer> find(
            final UUID id) {
        return this.getCustomer.apply(id);
    }
}
