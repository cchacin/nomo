package customers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

@DisplayName("Service should")
class ServiceShould extends Assertions {

    private final UUID id = UUID.randomUUID();

    @Test
    @DisplayName("store customer in db and cache")
    void store_customer_in_db_and_cache() throws Exception {
        // Given
        final var customer = Customer.create(this.id, this.id.toString());

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
        sut.create(customer);
    }

    @Test
    @DisplayName("return customer from db when not present in cache")
    void return_customer_from_db_when_not_present_in_cache() throws Exception {
        // Given
        final var customer = Customer.create(this.id, this.id.toString());

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
    @DisplayName("return customer from cache when present")
    void return_customer_from_cache_when_present() throws Exception {
        // Given
        final var customer = Customer.create(this.id, this.id.toString());

        // When
        final var sut = new Service(
                uuid -> Optional.of(customer),
                uuid -> Optional.empty(),
                cust -> {
                },
                cust -> {
                }
        );

        // Then
        assertThat(sut.find(this.id)).contains(Customer.create(this.id, this.id.toString()));
    }

    @Test
    @DisplayName("return empty when present in cache/db")
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