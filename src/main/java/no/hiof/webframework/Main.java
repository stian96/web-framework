package no.hiof.webframework;
import no.hiof.webframework.controllers.TestController;
import no.hiof.webframework.servers.ConfigureServer;


public class Main {
    public static void main(String[] args) throws Exception {


        ConfigureServer server = ConfigureServer.getInstance();
        server.setPortNumber(8080);
        server.setServerEndpoint("/");
        server.addControllerToServer(new TestController(), "/test");
        server.addStaticResource("test.html", "./src/main/webapp");
        server.startServer();

    }
}
