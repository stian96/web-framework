package no.hiof.webframework;

import no.hiof.webframework.application.App;

public class Main {
    public static void main(String[] args) {

        App app = App.create();
        app.setApplicationTitle("h");
        app.run();

    }
}
