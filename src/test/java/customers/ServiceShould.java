package customers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@DisplayName("Service should")
class ServiceShould extends Assertions {

    private final UUID id = UUID.randomUUID();

    @Test
    @DisplayName("store customer in db and cache")
    void store_customer_in_db_and_cache() throws Exception {
        // Given
        final var customer = createCustomer();
        final var db = new ArrayList<Customer>();
        final var cache = new ArrayList<Customer>();

        // When
        final var sut = new Service(
                uuid -> Optional.empty(),
                uuid -> Optional.empty(),
                db::add,
                cache::add
        );

        // Then
        sut.create(customer);
        assertThat(db).contains(customer);
        assertThat(cache).contains(customer);
    }

    @Test
    @DisplayName("return customer from db when not present in cache")
    void return_customer_from_db_when_not_present_in_cache() throws Exception {
        // Given
        final var customer = createCustomer();
        final var db = new ArrayList<Customer>();
        final var cache = new ArrayList<Customer>();

        // When
        final var sut = new Service(
                uuid -> Optional.empty(),
                uuid -> Optional.of(customer),
                db::add,
                cache::add
        );

        // Then
        assertThat(sut.find(this.id)).contains(createCustomer());
        assertThat(db).isEmpty();
        assertThat(cache).contains(customer);
    }

    private Customer createCustomer() {
        return Customer.create(this.id, this.id.toString());
    }

    @Test
    @DisplayName("return customer from cache when present")
    void return_customer_from_cache_when_present() throws Exception {
        // Given
        final var customer = createCustomer();
        final var db = new ArrayList<Customer>();
        final var cache = new ArrayList<Customer>();

        // When
        final var sut = new Service(
                uuid -> Optional.of(customer),
                uuid -> Optional.empty(),
                db::add,
                cache::add
        );

        // Then
        assertThat(sut.find(this.id)).contains(createCustomer());
        assertThat(cache).isEmpty();
        assertThat(db).isEmpty();
    }

    @Test
    @DisplayName("return empty when present in cache/db")
    void returnEmpty() throws Exception {
        // Given
        final var db = new ArrayList<Customer>();
        final var cache = new ArrayList<Customer>();

        // When
        final var sut = new Service(
                uuid -> Optional.empty(),
                uuid -> Optional.empty(),
                db::add,
                cache::add
        );
        // Then
        assertThat(sut.find(this.id)).isEmpty();
        assertThat(cache).isEmpty();
        assertThat(db).isEmpty();
    }
}