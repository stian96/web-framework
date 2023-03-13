package org.example;

import org.example.Application.App;

public class Main {
    public static void main(String[] args) {

        App application = new App();
        application.addRoute("login", "Login Page");
        application.addLoginForm();
        application.run();
    }
}