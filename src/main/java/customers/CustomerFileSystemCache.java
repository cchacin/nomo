package customers;

import java.util.Optional;
import java.util.UUID;

class CustomerFileSystemCache implements CustomerCache {
    
    @Override
    public void saveToCache(Customer customer) {
        System.out.println("SAVED TO FILE SYSTEM");
    }

    @Override
    public Optional<Customer> getFromCache(UUID id) {
        System.out.println("RETRIVED FROM FILE SYSTEM");
        return Optional.empty();
    }

    @Override
    public void method1() {

    }

    @Override
    public String method2() {
        return null;
    }
}
