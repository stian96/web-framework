package no.hiof.webframework;
import no.hiof.webframework.application.logging.Logger;
import no.hiof.webframework.controllers.TestController;
import no.hiof.webframework.servers.ConfigureServer;


public class Main {
    public static void main(String[] args) throws Exception {


        ConfigureServer server = new ConfigureServer.Builder()
                .setPortNumber(8080)
                .setServerEndpoint("/")
                .addController(new TestController(), "/test")
                .addStaticResources("test.html", "./src/main/webapp")
                .build();

        server.startServer();

    }
}
