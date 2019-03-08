package customers;

import java.util.Optional;
import java.util.UUID;

class FileSystemCache {

    public void saveToCache(final Customer customer) {
        System.out.println("SAVED TO FILE SYSTEM");
    }

    public Optional<Customer> getFromCache(final UUID id) {
        System.out.println("RETRIVED FROM FILE SYSTEM");
        return Optional.empty();
    }

    public void method1() {

    }

    public String method2() {
        return null;
    }
}
