package org.example;

import org.example.Application.App;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.addRoute("login", "Login Page!");
        app.addLoginForm();

        app.run();
    }
}