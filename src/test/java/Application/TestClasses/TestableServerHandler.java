package Application.TestClasses;

import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Frontend.HtmlPages;
import no.hiof.webframework.Application.ServerHandler;
import no.hiof.webframework.Exceptions.NoHtmlContentException;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

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

    @Override
    public void addServletToContext(ServletContextHandler contextHandler, App app) throws NoHtmlContentException {
        super.addServletToContext(contextHandler, app);
    }
}
