import customers.AppFactory;
import customers.CustomerEndpoint;

import java.util.UUID;

public class App {

    public static void main(String[] args) {
        final CustomerEndpoint endpoint = AppFactory.endpoint();
        System.out.println(endpoint.find(UUID.randomUUID()));
    }
}
