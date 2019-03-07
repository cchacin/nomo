package customers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

class ServiceITest extends Assertions {

    @Test
    void storeCustomerInDbAndCache() throws Exception {
        final TestFactory appFactory = DaggerTestFactory.builder().build();
        final CustomerEndpoint endpoint = appFactory.endpoint();
        final Optional<Customer> customer = endpoint.find(UUID.randomUUID());
        assertThat(customer).isEmpty();
    }
}
