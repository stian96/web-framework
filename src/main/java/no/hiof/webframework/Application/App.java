package no.hiof.webframework.Application;
import no.hiof.webframework.Application.Parser.HtmlParser;
import no.hiof.webframework.Frontend.HtmlPages;
import no.hiof.webframework.Application.Routes.Route;
import no.hiof.webframework.Repository.UserDb;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.server.Server;
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
    private String customPage, applicationTitle;
    private UserDb dbUser;
    private String content;
    protected int titleCounter;

    public App() {
        this.titleCounter = 0;
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

    public void addCustomHtmlPage(String page, UserDb user) {
        String title = HtmlParser.readCustomHtmlPage(page);
        setCustomPage(page);
        dbUser = user;
        htmlPageMap.put(title, null);
    }

    public void addDefaultPage(String content) {
        setContent(content);
        htmlPageMap.put(content, null);
    }

    /**
     * Starts and run the application. Program can be
     * run after this method is called.
     */
    public void run() {
        Logger.turnLoggerOFF();
        printUrlInformation();

        ServerHandler server;
        if (applicationTitle != null)
            server = new ServerHandler(applicationTitle);
        else
            server = new ServerHandler();
        server.initializeHandler(new Server(PORT), this);
    }

    private void printUrlInformation() {
        System.out.print("Listening on port: ");
        System.out.println("http://localhost:" + PORT + "/");
    }

    private void setCustomPage(String content) {
        customPage = content;
    }

    protected Map<String, Route> getRouteMap() {
        return routeMap;
    }

    protected Map<String, HtmlPages> getHtmlPageMap() {
        return htmlPageMap;
    }

    private void setContent(String content) {
        this.content = content;
    }

    protected String getContent() {
        return content;
    }

    protected String getCustomPage() {
        return customPage;
    }

    public void setApplicationTitle(String title) {
        this.applicationTitle = title;
    }

    protected UserDb getDbUser() {
        return dbUser;
    }

    protected void setDbUser(UserDb dbUser) {
        this.dbUser = dbUser;
    }
}

