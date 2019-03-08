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

    private final UUID id = UUID.randomUUID();

    @Test
    void storeCustomer(
            @Mock final Service service) throws Exception {
        // Given
        final var customer = Customer.create(this.id, this.id.toString());

        // When
        var sut = new CustomerEndpoint(service);

        // Then
        sut.create(customer);
        verify(service).create(customer);
    }

    @Test
    void returnCustomer(
            @Mock final Service service) throws Exception {
        // Given
        final var customer = Customer.create(this.id, this.id.toString());
        when(service.find(this.id)).thenReturn(Optional.of(customer));

        // When
        var sut = new CustomerEndpoint(service);

        // Then
        assertThat(sut.find(this.id)).contains(Customer.create(this.id, this.id.toString()));
    }

    @Test
    void returnEmpty(
            @Mock final Service service) throws Exception {
        // Given

        // When
        var sut = new CustomerEndpoint(service);

        // Then
        assertThat(sut.find(this.id)).isEmpty();
    }
}