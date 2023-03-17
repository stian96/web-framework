package no.hiof.webframework.Application;

import no.hiof.webframework.Enum.PageType;
import no.hiof.webframework.Frontend.HtmlPages;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import no.hiof.webframework.Routes.Route;
import no.hiof.webframework.Servlet.ShowContent;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Application class:
 * Users can instantiate the application by creating a new instance of the class.
 */

public class App {
    private static final int PORT = 8080;
    private final ArrayList<HtmlPages> htmlPageList = new ArrayList<>();
    private final Map<String, Route> routeMap = new HashMap<>();

    // Empty constructor
    public App() {
    }


    public void addRoute(String endpoint, HttpMethod httpMethod) {
        Route route = new Route(endpoint, httpMethod);
        routeMap.put(endpoint, route);
    }

    /**
     * Adds a ready-made html page to the specified route,
     * where all the html and css is pre-built.
     */
    public void addHtmlPage(InputStream htmlPage, String title, PageType type) {
        HtmlPages page = new HtmlPages(type);
        page.setHtmlPage(htmlPage);
        page.setTitle(title);
        htmlPageList.add(page);
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
        Map<String, ServletHolder> servletMap = new HashMap<>();

        for (Map.Entry<String, Route> entry : routeMap.entrySet()) {
            String endpoint = entry.getValue().getRoute();
            String target = "/" + endpoint + "/*";

            if (!checkForHtmlForm()) {
                for (HtmlPages page : htmlPageList) {
                    if (!servletMap.containsKey(target)) {
                        ServletHolder servletHolder = new ServletHolder(new ShowContent(page.getTitle(), page.getPageType()));
                        context.addServlet(servletHolder, target);
                        servletMap.put(target, servletHolder);
                    }
                }
            }
        }
    }

    private boolean checkForHtmlForm() {
        return htmlPageList.size() == 0;
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
