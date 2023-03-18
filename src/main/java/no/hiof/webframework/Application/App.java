package no.hiof.webframework.Application;
import no.hiof.webframework.Exceptions.NoHtmlContentException;
import no.hiof.webframework.Frontend.HtmlPages;
import no.hiof.webframework.Servlet.HomeServlet;
import no.hiof.webframework.Servlet.LoginServlet;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import no.hiof.webframework.Routes.Route;

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
    private final Map<String, Route> routeMap = new HashMap<>();
    private final ArrayList<HtmlPages> htmlPageList = new ArrayList<>();
    private String loginPageTitle;
    private String homePageTitle;


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
    public void addHtmlPage(InputStream htmlPage) {
        HtmlPages page = new HtmlPages();
        page.setHtmlPage(htmlPage);
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

    private void addServletToContext(ServletContextHandler context) throws NoHtmlContentException {

        Map<String, ServletHolder> servletMap = new HashMap<>();
        for (Map.Entry<String, Route> entry : routeMap.entrySet()) {

            Route route = entry.getValue();
            String endpoint = route.getRoute();
            String target = "/" + endpoint + "/*";

            if (!checkForHtmlPage()) {
                addServletIfNeeded(endpoint, target, servletMap, context);
            }
            else {
                throw new NoHtmlContentException("Need to add html pages to the application.");
            }
        }
    }

    private void addServletIfNeeded(String endpoint, String target, Map<String, ServletHolder> servletMap, ServletContextHandler context) {

        for (HtmlPages page : htmlPageList) {
            if (!servletMap.containsKey(target)) {
                ServletHolder servlet = getServlet(endpoint, page);
                context.addServlet(servlet, target);
                servletMap.put(target, servlet);
            }
        }
    }

    private ServletHolder getServlet(String endpoint, HtmlPages page) {
        if (endpoint.equals("login")) {
            return new ServletHolder(new LoginServlet(page, loginPageTitle));
        }
        else if (endpoint.equals("home")) {
            return new ServletHolder(new HomeServlet(page, homePageTitle));
        }
        else {
            throw new IllegalArgumentException("Unsupported endpoint: " + endpoint);
        }
    }

    private boolean checkForHtmlPage() {
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
        System.out.println("http://localhost:" + PORT + "/");
    }

    public void setLoginPageTitle(String loginPageTitle) {
        this.loginPageTitle = loginPageTitle;
    }

    public void setHomePageTitle(String homePageTitle) {
        this.homePageTitle = homePageTitle;
    }
}
