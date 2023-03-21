package no.hiof.webframework.Servers;

import no.hiof.webframework.Application.Logger;
import no.hiof.webframework.Controllers.MyController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ControllerServer {
    private static final int PORT = 8080;
    private final Server server;
    private final ServletContextHandler context;

    public ControllerServer(String endpoint) {
        Logger.turnLoggerOFF();
        this.server = new Server(PORT);
        this.context = new ServletContextHandler();
        context.setContextPath("/" + endpoint);
        server.setHandler(context);
    }

    public void addController(MyController controller) throws Exception {
        context.addServlet(new ServletHolder(controller), "/*");
        server.start();
    }
}

