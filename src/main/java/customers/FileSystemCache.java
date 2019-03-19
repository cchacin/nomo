package customers;

import java.util.Optional;
import java.util.UUID;

class FileSystemCache {

    void saveToCache(final Customer customer) {
        System.out.println("SAVED TO FILE SYSTEM");
    }

    Optional<Customer> getFromCache(final UUID id) {
        System.out.println("RETRIVED FROM FILE SYSTEM");
        return Optional.empty();
    }

    void method1() {
    }

    String method2() {
        return null;
    }
}
