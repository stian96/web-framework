package no.hiof.webframework;

import no.hiof.webframework.Application.App;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.addRoute("login", "Login");
        app.addLoginForm();

        app.run();
    }
}