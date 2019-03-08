package customers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@DisplayName("Service should")
@ExtendWith(MockitoExtension.class)
class ServiceShould extends Assertions {

    private UUID id = UUID.randomUUID();

    @Test
    @DisplayName("store customer in db and cache")
    void store_customer_in_db_and_cache(
            @Mock Repository repository,
            @Mock Cache cache) throws Exception {
        // Given
        var customer = Customer.create(id, id.toString());

        // When
        var sut = new Service(repository, cache);

        // Then
        sut.create(customer);
        var inOrder = Mockito.inOrder(repository, cache);
        inOrder.verify(repository).saveToDb(customer);
        inOrder.verify(cache).saveToCache(customer);
    }

    @Test
    @DisplayName("return customer from db when not present in cache")
    void return_customer_from_db_when_not_present_in_cache(
            @Mock Repository repository,
            @Mock Cache cache) throws Exception {
        // Given
        var customer = Customer.create(id, id.toString());
        when(cache.getFromCache(id)).thenReturn(Optional.empty());
        when(repository.getFromDb(id)).thenReturn(Optional.of(customer));

        // When
        var sut = new Service(repository, cache);

        // Then
        assertThat(sut.find(id)).contains(Customer.create(id, id.toString()));
        verify(cache).saveToCache(customer);
    }

    @Test
    @DisplayName("return customer from cache when present")
    void return_customer_from_cache_when_present(
            @Mock Repository repository,
            @Mock Cache cache) throws Exception {
        // Given
        var customer = Customer.create(id, id.toString());
        when(cache.getFromCache(id)).thenReturn(Optional.of(customer));

        // When
        var sut = new Service(repository, cache);

        // Then
        assertThat(sut.find(id)).contains(Customer.create(id, id.toString()));
        verify(repository, never()).getFromDb(any());
        verifyNoMoreInteractions(cache);
    }

    @Test
    @DisplayName("return empty when present in cache/db")
    void returnEmpty(
            @Mock Repository repository,
            @Mock Cache cache) throws Exception {
        // Given

        // When
        var sut = new Service(repository, cache);

        // Then
        assertThat(sut.find(id)).isEmpty();
    }
}