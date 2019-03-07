import customers.CustomerAppFactory;
import customers.CustomerEndpoint;
import customers.DaggerCustomerAppFactory;

import java.util.UUID;

public class App {

    public static void main(String[] args) {

        final CustomerAppFactory customerActivityFactory = DaggerCustomerAppFactory.builder().build();
        final CustomerEndpoint endpoint = customerActivityFactory.endpoint();
        System.out.println(endpoint.find(UUID.randomUUID()));

    }
}
