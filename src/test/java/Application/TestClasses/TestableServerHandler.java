package Application.TestClasses;

import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.ServerHandler;
import org.eclipse.jetty.server.Server;

public class TestableServerHandler extends ServerHandler {

    public boolean startServerCalled = false;

    @Override
    public void startServer(Server server) throws Exception {
        super.startServer(server);

        startServerCalled = true;
    }

    @Override
    public void initializeHandler(Server server, App app) {
        super.initializeHandler(server, app);
    }

}
