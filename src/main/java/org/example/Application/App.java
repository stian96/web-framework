package org.example.Application;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.Interface.IRoute;
import org.example.Routes.Route;
import org.example.Servlet.ShowContent;

import java.util.ArrayList;

public class App {
    private static final int PORT = 8080;
    private final ArrayList<IRoute> routeList = new ArrayList<>();

    // Empty constructor
    public App() {
    }

    public void addRoute(String endpoint, String title) {
        routeList.add(new Route(endpoint, title));
    }

    private void initializeHandler(Server server) {
        try {
            ServletContextHandler context = new ServletContextHandler();
            context.setContextPath("/");
            addServletToContext(context);

            server.setHandler(context);
            startServer(server);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private void addServletToContext(ServletContextHandler context) {
        for (IRoute route : routeList) {
            String endpoint = route.getRoute();
            String content = route.getTitle();

            String target = "/" + endpoint + "/*";
            context.addServlet(new ServletHolder(new ShowContent(content)), target);
        }
    }

    private void startServer(Server server) throws Exception {
        server.start();
        server.join();
    }

    public void run() {
        printUrlInformation();
        Server server = new Server(PORT);
        initializeHandler(server);
    }

    private void printUrlInformation() {
        System.out.print("Listening on port: ");
        System.out.println("http://localhost:8080/");
    }
}
