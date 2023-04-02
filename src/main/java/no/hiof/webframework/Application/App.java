package no.hiof.webframework.Application;
import no.hiof.webframework.Application.Frontend.HtmlPages;
import no.hiof.webframework.Application.Logging.Logger;
import no.hiof.webframework.Application.Parser.HtmlParser;
import no.hiof.webframework.Controllers.Controller;
import no.hiof.webframework.Application.Routes.Route;
import no.hiof.webframework.Repository.UserDb;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.server.Server;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * The App class is the core class of the application, responsible for managing
 * the web server and handling HTTP requests. It uses the Singleton pattern to
 * ensure that only one instance of the class exists at any given time.
 * <p>
 * The class maintains a collection of routes and associated HTTP methods, and
 * provides methods for adding custom or pre-built HTML pages and responses to
 * specific routes. It also allows a custom controller to be added for handling
 * dynamic content, and provides access to a user database if needed.
 * <p>
 * To use the App class, call the create() method to obtain an instance, then
 * use the various add methods to define routes and content, and finally call
 * the run() method to start the server and listen for incoming requests.
 */
public class App {

    private static App instance = null;
    private static final int PORT = 8080;
    private final Map<String, Route> routeMap = new LinkedHashMap<>();
    private final Map<String, HtmlPages> htmlPageMap = new LinkedHashMap<>();
    private String customPage, applicationTitle;

    private Controller controller;
    private UserDb dbUser;

    private String response;
    /**
     * The 'pageCounter' is used to control how many
     * pages that the server needs to handle.
     */
    protected int pageCounter;

    // Constructor used for testing. Will be set to private later.
    public App() {}

    /**
     * Method used to create only one instance of the App-class.
     * @return The application object.
     */
    public static App create() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    // TODO: Need to update this documentation to include the exceptions.
    /**
     * Adds a new route to the application.
     * @param endpoint URI value of the URL.
     * @param httpMethod Method to be used (e.g. GET, POST, PUT etc.)
     */

    public void addRoute(String endpoint, HttpMethod httpMethod) {
        Route route = new Route(endpoint, httpMethod);

        if (endpoint == null)
            throw new NullPointerException("Endpoint cannot be null!");

        else if (httpMethod == null)
            throw new NullPointerException("HttpMethod cannot be null!");

        routeMap.put(endpoint, route);
    }

    /**
     * Adds a ready-made html page to the specified route,
     * where all the html and css is pre-built.
     * @param htmlPage InputStream of the html page. You
     * can get this from the HtmlFactory.
     * @param title Sets the title of the page.
     */
    public void addHtmlPage(InputStream htmlPage, String title)  {
        HtmlPages page = new HtmlPages();
        page.setHtmlPage(htmlPage);
        page.setTitle(title);

        String pageTitle = HtmlParser.getTitleFromHtmlPage(htmlPage);
        htmlPageMap.put(pageTitle, page);
    }

    /**
     * Adds a custom html page to the application.
     * @param page The html page as a String.
     * Can get this from the build() method in the
     * HtmlPageBuilder class.
     */
    public void addCustomHtmlPage(String page) {
        String title = HtmlParser.readCustomHtmlPage(page);
        setCustomPage(page);
        htmlPageMap.put(title, null);

    }

    /**
     * Adds a custom html page that is connected to
     * a user database.
     * @param page The html page as a String.
     * @param user User database from 'UserDb' class.
     */
    public void addCustomHtmlPage(String page, UserDb user) {
        String title = HtmlParser.readCustomHtmlPage(page);
        setCustomPage(page);
        dbUser = user;
        htmlPageMap.put(title, null);
    }

    /**
     * Adds a response as a String to a page with no html content.
     * @param response The response to be delivered on the page.
     */
    public void addResponseToPage(String response) {
        setResponse(response);
        htmlPageMap.put(response, null);
    }

    /**
     * Adds a controller to the server.
     * @param controller The controller to be passed.
     */
    public void addController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Starts and run the application. Program can be
     * run after this method is called.
     */
    public void run() {
        Logger.turnLoggerOFF();
        printUrlInformation();

        ServerHandler server = constructorHandler();
        server.initializeHandler(new Server(PORT), this);
    }

    private ServerHandler constructorHandler() {
        if (applicationTitle != null && controller == null)
            return new ServerHandler(applicationTitle);

        else if (controller != null && applicationTitle == null)
            return new ServerHandler(controller);

        else if (controller == null)
            return new ServerHandler();

        else
            return new ServerHandler(applicationTitle, controller);
    }

    private void printUrlInformation() {
        System.out.print("Listening on port: ");
        System.out.println("http://localhost:" + PORT + "/");
    }

    private void setCustomPage(String content) {
        customPage = content;
    }

    /**
     * Getter used to retrieve the route map collection.
     * @return A 'LinkedHashMap' containing Strings and Route-objects.
     */
    public Map<String, Route> getRouteMap() {
        return routeMap;
    }

    /**
     * Getter used to retrieve the html-page map collection.
     * @return The 'LinkedHashMap' containing Strings and HtmlPages.
     */
    public Map<String, HtmlPages> getHtmlPageMap() {
        return htmlPageMap;
    }

    private void setResponse(String content) {
        this.response = content;
    }

    /**
     * Getter used to retrieve a response for pages without html content.
     * @return The response as a String.
     */
    protected String getResponse() {
        return response;
    }

    /**
     * Getter used to retrieve the content of a 'custom' html page.
     * @return The custom page as a String.
     */
    protected String getCustomPage() {
        return customPage;
    }

    /**
     * Setter used to set the title of the application.
     * @param title A String value representing the title.
     */
    public void setApplicationTitle(String title) {
        this.applicationTitle = title;
    }

    /**
     * Getter used to retrieve the user-database.
     * @return A UserDb object.
     */
    protected UserDb getDbUser() {
        return dbUser;
    }

    /**
     * Returns the instance of the App object.
     * @return The instance to be returned.
     */
    public App getInstance() {
        return instance;
    }
}

