package customers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

class EndpointShould extends Assertions {

    private final UUID id = UUID.randomUUID();

    @Test
    void storeCustomer() throws Exception {
        // Given
        var customer = Customer.create(this.id, this.id.toString());

        // When
        final var sut = new Service(
                uuid -> Optional.empty(),
                uuid -> Optional.of(customer),
                cust -> {
                },
                cust -> {
                }
        );


        // Then
        sut.create(customer);
    }

    @Test
    void returnCustomer() throws Exception {
        // Given
        var customer = Customer.create(this.id, this.id.toString());

        // When
        final var sut = new Service(
                uuid -> Optional.empty(),
                uuid -> Optional.of(customer),
                cust -> {
                },
                cust -> {
                }
        );


        // Then
        assertThat(sut.find(this.id)).contains(Customer.create(this.id, this.id.toString()));
    }

    @Test
    void returnEmpty() throws Exception {
        // Given

        // When
        final var sut = new Service(
                uuid -> Optional.empty(),
                uuid -> Optional.empty(),
                cust -> {
                },
                cust -> {
                }
        );


        // Then
        assertThat(sut.find(this.id)).isEmpty();
    }
}