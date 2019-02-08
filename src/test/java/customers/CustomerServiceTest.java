package customers;

import com.example.app.cache.CustomerCache;
import com.example.app.domain.Customer;
import com.example.app.repository.CustomerRepository;
import com.example.app.service.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest extends Assertions {

    private UUID id = UUID.randomUUID();

    @Test
    void storeCustomerInDbAndCache(
            @Mock CustomerRepository repository,
            @Mock CustomerCache cache) throws Exception {
        // Given
        var customer = Customer.create(id, id.toString());

        // When
        var sut = new CustomerService(repository, cache);

        // Then
        sut.create(customer);
        var inOrder = Mockito.inOrder(repository, cache);
        inOrder.verify(repository).saveToDb(customer);
        inOrder.verify(cache).saveToCache(customer);
    }

    @Test
    void returnCustomerFromDb(
            @Mock CustomerRepository repository,
            @Mock CustomerCache cache) throws Exception {
        // Given
        var customer = Customer.create(id, id.toString());
        when(cache.getFromCache(id)).thenReturn(Optional.empty());
        when(repository.getFromDb(id)).thenReturn(Optional.of(customer));

        // When
        var sut = new CustomerService(repository, cache);

        // Then
        assertThat(sut.find(id)).contains(Customer.create(id, id.toString()));
        verify(cache).saveToCache(customer);
    }

    @Test
    void returnCustomerFromCache(
            @Mock CustomerRepository repository,
            @Mock CustomerCache cache) throws Exception {
        // Given
        var customer = Customer.create(id, id.toString());
        when(cache.getFromCache(id)).thenReturn(Optional.of(customer));

        // When
        var sut = new CustomerService(repository, cache);

        // Then
        assertThat(sut.find(id)).contains(Customer.create(id, id.toString()));
        verify(repository, never()).getFromDb(any());
        verifyNoMoreInteractions(cache);
    }

    @Test
    void returnEmpty(
            @Mock CustomerRepository repository,
            @Mock CustomerCache cache) throws Exception {
        // Given

        // When
        var sut = new CustomerService(repository, cache);

        // Then
        assertThat(sut.find(id)).isEmpty();
    }
}