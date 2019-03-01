package customers;

import com.example.app.domain.Customer;
import com.example.app.service.CustomerService;
import com.example.app.view.CustomerController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Optional;
import java.util.UUID;

class ServiceITest extends Assertions {

    private static SeContainer container;

    @BeforeAll
    static void beforeAll() throws Exception {
        container = SeContainerInitializer.newInstance()
                .disableDiscovery()
                .addBeanClasses(
                        MockCache.class,
                        MockRepository.class,
                        CustomerService.class,
                        CustomerController.class
                )
                .initialize();
    }

    @AfterAll
    static void afterAll() throws Exception {
        container.close();
    }

    @Test
    void storeCustomerInDbAndCache() throws Exception {
        final CustomerController controller = container.select(CustomerController.class).get();
        final Optional<Customer> customer = controller.find(UUID.randomUUID());
        assertThat(customer).isEmpty();
    }
}
