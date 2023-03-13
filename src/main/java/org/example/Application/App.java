package org.example.Application;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.Form.HtmlForm;
import org.example.Interface.IHtmlForm;
import org.example.Interface.IRoute;
import org.example.Routes.Route;
import org.example.Servlet.ShowContent;

import java.util.ArrayList;

public class App {
    private static final int PORT = 8080;
    private final ArrayList<IRoute> routeList = new ArrayList<>();
    private final ArrayList<IHtmlForm> htmlFormList = new ArrayList<>();

    // Empty constructor
    public App() {
    }

    public void addRoute(String endpoint, String title) {
        routeList.add(new Route(endpoint, title));
    }

    public void addLoginForm() {
        htmlFormList.add(new HtmlForm());
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
            String title = route.getTitle();

            String target = "/" + endpoint + "/*";

            if (!checkForHtmlForm()) {
                for (IHtmlForm form : htmlFormList)
                    context.addServlet(new ServletHolder(new ShowContent(title, form)), target);
            }
            else {
                context.addServlet(new ServletHolder(new ShowContent(title)), target);
            }
        }
    }

    private boolean checkForHtmlForm() {
        return htmlFormList.size() == 0;
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
