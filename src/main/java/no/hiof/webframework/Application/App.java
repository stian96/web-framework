package no.hiof.webframework.Application;

import no.hiof.webframework.Form.HtmlForm;
import no.hiof.webframework.Interface.IHtmlForm;
import no.hiof.webframework.Interface.IRoute;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import no.hiof.webframework.Routes.Route;
import no.hiof.webframework.Servlet.ShowContent;

import java.util.ArrayList;

/**
 * Application class:
 * Users can instantiate the application by creating a new instance of the class.
 */

public class App {
    private static final int PORT = 8080;
    private final ArrayList<IRoute> routeList = new ArrayList<>();
    private final ArrayList<IHtmlForm> htmlFormList = new ArrayList<>();

    // Empty constructor
    public App() {
    }

    /**
     * Adds a new route to the application.
     * @param endpoint defines the endpoint to the route.
     * @param title sets the title on the new page.
     */
    public void addRoute(String endpoint, String title) {
        routeList.add(new Route(endpoint, title));
    }

    /**
     * Adds a ready-made login page to the specified route,
     * where all of the html and css is pre-built.
     */
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

    /**
     * Starts and run the application. After this method is
     * executed, you can run the program.
     */
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
