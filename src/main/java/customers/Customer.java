package customers;

import java.util.Objects;
import java.util.UUID;

final class Customer {

    private final UUID id;
    private final String name;

    public Customer(
            final UUID id,
            final String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(
            final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Customer customer = (Customer) o;
        return Objects.equals(this.id, customer.id) &&
                Objects.equals(this.name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                '}';
    }

    public static Customer create(
            final UUID id,
            final String name) {
        return new Customer(id, name);
    }
}
