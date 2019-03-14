package com.example.app;

import com.example.app.view.CustomerEndpoint;

import java.util.UUID;

public class App {

    public static void main(String[] args) {

        final AppFactory appFactory = DaggerAppFactory.builder().build();
        final CustomerEndpoint endpoint = appFactory.endpoint();
        System.out.println(endpoint.find(UUID.randomUUID()));

    }
}
