package customers;

import com.example.app.AppFactory;
import com.example.app.DaggerAppFactory;
import com.example.app.domain.Customer;
import com.example.app.view.CustomerActivity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

class ServiceITest extends Assertions {

    @Test
    void storeCustomerInDbAndCache() throws Exception {
        final AppFactory appFactory = DaggerAppFactory.builder().build();
        final CustomerActivity controller = appFactory.controller();
        final Optional<Customer> customer = controller.find(UUID.randomUUID());
        assertThat(customer).isEmpty();
    }
}
