package customers;

import com.example.app.domain.Customer;
import com.example.app.view.CustomerActivity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

class ServiceITest extends Assertions {

    @Test
    void storeCustomerInDbAndCache() throws Exception {
        final TestFactory appFactory = DaggerTestFactory.builder().build();
        final CustomerActivity activity = appFactory.activity();
        final Optional<Customer> customer = activity.find(UUID.randomUUID());
        assertThat(customer).isEmpty();
    }
}
