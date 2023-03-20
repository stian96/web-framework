package no.hiof.webframework.Application;
import no.hiof.webframework.Application.Parser.HtmlParser;
import no.hiof.webframework.Exceptions.NoHtmlContentException;
import no.hiof.webframework.Frontend.CustomHtmlPage;
import no.hiof.webframework.Frontend.HtmlPages;
import no.hiof.webframework.Routes.Route;
import no.hiof.webframework.Servlet.*;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Application class: App name = new App();
 */

public class App {
    private static final int PORT = 8080;
    private final Map<String, Route> routeMap = new LinkedHashMap<>();
    private final Map<String, HtmlPages> htmlPageMap = new LinkedHashMap<>();

    private String applicationTitle, loginPageTitle, homePageTitle, logoutPageTitle;
    private String customPage;
    private int titleCounter = 0;

    public App() {
    }

    /**
     * Adds a new route to the application.
     * @param endpoint URI value of the URL.
     * @param httpMethod Method to be used (e.g. GET, POST, PUT etc.)
     */
    public void addRoute(String endpoint, HttpMethod httpMethod) {
        Route route = new Route(endpoint, httpMethod);
        routeMap.put(endpoint, route);
    }

    /**
     * Adds a ready-made html page to the specified route,
     * where all the html and css is pre-built.
     * @param htmlPage InputStream of the html page. You
     * can get this from the HtmlFactory.
     */
    public void addHtmlPage(InputStream htmlPage)  {
        HtmlPages page = new HtmlPages();
        page.setHtmlPage(htmlPage);

        String title = HtmlParser.getTitleFromHtmlPage(htmlPage);
        htmlPageMap.put(title, page);
    }

    public void addCustomHtmlPage(CustomHtmlPage page) {
        String title = HtmlParser.readCustomHtmlPage(page.getContent());
        setCustomPage(page.getContent());
        htmlPageMap.put(title, null);

    }

    private void initializeHandler(Server server) {
        try {
            ServletContextHandler context = new ServletContextHandler();
            context.setContextPath("/");
            addServletToContext(context);

            if (applicationTitle != null) {
                DefaultServlet.setApplicationTitle(applicationTitle);
                context.addServlet(DefaultServlet.class, "/");
            }

            server.setHandler(context);
            startServer(server);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private void addServletToContext(ServletContextHandler context) throws NoHtmlContentException {
        for (Map.Entry<String, Route> entry : routeMap.entrySet()) {
            Route route = entry.getValue();
            String uri = "/" + route.getRoute() + "/*";
            String keySet = htmlPageMap.keySet().toString();

            if (!checkForHtmlPage()) {
                addServletIfNeeded(keySet, uri, context);
                titleCounter++;
            }
            else {
                throw new NoHtmlContentException("Need to add html pages to the application.");
            }
        }
    }

    private void addServletIfNeeded(String titleSet, String uri, ServletContextHandler context) {
        String [] titles = mapSetToArray(titleSet);

        if (titleCounter <= htmlPageMap.size() - 1) {
            HtmlPages page = htmlPageMap.get(titles[titleCounter].trim());
            ServletHolder servlet = getServlet(titles[titleCounter].trim(), page);
            context.addServlet(servlet, uri);
        }
    }

    private String[] mapSetToArray(String set) {
        if (set != null) {
            set = set.replace("[", "").replace("]", "");
            return set.split(",");
        }
        return null;
    }

    private ServletHolder getServlet(String title, HtmlPages page) {
        return switch (title) {
            case "Login Page" -> new ServletHolder(new LoginServlet(page, loginPageTitle));
            case "Home Page" -> new ServletHolder(new HomeServlet(page, homePageTitle));
            case "Logout Page" -> new ServletHolder(new LogoutServlet(page, logoutPageTitle));
            case "Custom Page" -> new ServletHolder(new CustomServlet(customPage));
            default -> throw new IllegalArgumentException("error");
        };
    }

    private boolean checkForHtmlPage() {
        return htmlPageMap.size() == 0;
    }

    private void startServer(Server server) throws Exception {
        server.start();
        server.join();
    }

    /**
     * Starts and run the application. Program can be
     * run after this method is called.
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

    /**
     * Sets the title of the login html-page.
     * @param loginPageTitle The title to be set.
     */
    public void setLoginPageTitle(String loginPageTitle) {
        this.loginPageTitle = loginPageTitle;
    }

    /**
     * Sets the title of the home html-page.
     * @param homePageTitle The title to be set.
     */
    public void setHomePageTitle(String homePageTitle) {
        this.homePageTitle = homePageTitle;
    }

    public void setLogoutPageTitle(String logoutPageTitle) {
        this.logoutPageTitle = logoutPageTitle;
    }

    public void setTitle(String title) {
        this.applicationTitle = title;
    }

    private void setCustomPage(String content) {
        customPage = content;
    }
}

