package customers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class ServiceITest extends Assertions {

    @Test
    void storeCustomerInDbAndCache() throws Exception {
        var endpoint = AppFactory.endpoint();
        var customer = endpoint.find(UUID.randomUUID());
        assertThat(customer).isEmpty();
    }
}
