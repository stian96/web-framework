package no.hiof.webframework;
import no.hiof.webframework.controllers.TestController;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/");
        servletContextHandler.addServlet(new ServletHolder(new TestController()), "/test");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{ "test.html" });
        resourceHandler.setResourceBase("./src/main/webapp");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { resourceHandler, servletContextHandler });

        server.setHandler(handlers);
        server.start();
        server.join();

    }
}
