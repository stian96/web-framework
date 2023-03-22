package no.hiof.webframework;


import no.hiof.webframework.Application.App;
import no.hiof.webframework.Controllers.MyController;

public class Main {
    public static void main(String[] args) {

        App myApp = App.create();
        myApp.addController(new MyController("hello"));
        myApp.run();
    }
}