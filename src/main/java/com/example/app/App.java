package com.example.app;

import com.example.app.view.CustomerActivity;

import java.util.UUID;

public class App {

    public static void main(String[] args) {

        final AppFactory appFactory = DaggerAppFactory.builder().build();
        final CustomerActivity controller = appFactory.controller();
        System.out.println(controller.find(UUID.randomUUID()));

    }
}
