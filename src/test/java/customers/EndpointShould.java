package customers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EndpointShould extends Assertions {

    private UUID id = UUID.randomUUID();

    @Test
    void storeCustomer(
            @Mock CustomerService service) throws Exception {
        // Given
        var customer = Customer.create(id, id.toString());

        // When
        var sut = new CustomerEndpoint(service);

        // Then
        sut.create(customer);
        verify(service).create(customer);
    }

    @Test
    void returnCustomer(
            @Mock CustomerService service) throws Exception {
        // Given
        var customer = Customer.create(id, id.toString());
        when(service.find(id)).thenReturn(Optional.of(customer));

        // When
        var sut = new CustomerEndpoint(service);

        // Then
        assertThat(sut.find(id)).contains(Customer.create(id, id.toString()));
    }

    @Test
    void returnEmpty(
            @Mock CustomerService service) throws Exception {
        // Given

        // When
        var sut = new CustomerEndpoint(service);

        // Then
        assertThat(sut.find(id)).isEmpty();
    }
}