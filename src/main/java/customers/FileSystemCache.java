package customers;

import java.util.Optional;
import java.util.UUID;

class FileSystemCache {

    public void saveToCache(Customer customer) {
        System.out.println("SAVED TO FILE SYSTEM");
    }

    public Optional<Customer> getFromCache(UUID id) {
        System.out.println("RETRIVED FROM FILE SYSTEM");
        return Optional.empty();
    }

    public void method1() {

    }

    public String method2() {
        return null;
    }
}
