package no.hiof.webframework;
import no.hiof.webframework.controllers.TestController;
import no.hiof.webframework.servers.ServerConfig;


public class Main {
    public static void main(String[] args) throws Exception {


        ServerConfig testServer = ServerConfig.getInstance();
        testServer.setServerEndpoint("/");
        testServer.addControllerToServer(new TestController(), "/test");
        testServer.addStaticResource("test.html", "./src/main/webapp");
        testServer.startServer();

    }
}
