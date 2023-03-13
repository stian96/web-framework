package org.example;

import org.example.Application.App;

public class Main {
    public static void main(String[] args) {

        App application = new App();
        application.addRoute("login", "This is the Login Page!");
        application.addRoute("home", "This is the Home Page!");
        application.addRoute("logout", "This is the Logout Page!");

        application.run();
    }
}