package application;

import no.hiof.webframework.application.App;
import no.hiof.webframework.application.frontend.HtmlFactory;
import no.hiof.webframework.application.frontend.HtmlPageBuilder;
import no.hiof.webframework.application.frontend.HtmlPages;
import application.TestClasses.MockApp;
import no.hiof.webframework.application.routes.Route;
import application.TestClasses.TestableApp;
import no.hiof.webframework.controllers.Controller;
import no.hiof.webframework.controllers.MyController;
import org.eclipse.jetty.http.HttpMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;


class AppTest {

    @Test
    void testAddRouteAddsRouteToRouteMap() {
        // setup
        TestableApp app = new TestableApp();
        HttpMethod method = HttpMethod.GET;
        String endpoint = "login";

        // action
        app.addRoute(endpoint, method);

        // verify
        Assertions.assertNotNull(app.getRouteMap());
        assertTrue(app.getRouteMap().containsKey("login"));
    }

    @Test
    void testAddRoute_handlesNullEndpoint() {
        // setup
        App app = new TestableApp();
        HttpMethod method = HttpMethod.GET;

        // action & verify
        Assertions.assertThrows(NullPointerException.class, () -> app.addRoute(null, method));
    }

    @Test
    void testAddRoute_handlesNullHttpMethod() {
        // setup
        App app = new TestableApp();
        String endpoint = "login";

        // action & verify
        Assertions.assertThrows(NullPointerException.class, () -> app.addRoute(endpoint, null));
    }

    @Test
    void testAddRoute_createsRouteWithCorrectValues() {
        // setup
        TestableApp app = new TestableApp();
        HttpMethod method = HttpMethod.GET;
        String endpoint = "login";

        // action
        app.addRoute(endpoint, method);

        // verify
        Map<String, Route> routeMap = app.getRouteMap();
        Assertions.assertNotNull(routeMap);
        Assertions.assertTrue(routeMap.containsKey(endpoint));

        Route route = routeMap.get(endpoint);
        Assertions.assertEquals(method, route.getHttpMethod());
    }

    @Test
    void testAddRoute_addsNewRouteToRouteMap() {
        // setup
        TestableApp app = new TestableApp();
        HttpMethod method = HttpMethod.GET;
        String endpoint1 = "login";
        String endpoint2 = "register";

        // action
        app.addRoute(endpoint1, method);
        app.addRoute(endpoint2, method);

        // verify
        Map<String, Route> routeMap = app.getRouteMap();
        Assertions.assertNotNull(routeMap);
        Assertions.assertTrue(routeMap.containsKey(endpoint1));
        Assertions.assertTrue(routeMap.containsKey(endpoint2));
    }

    @Test
    void testAddRoute_doesNotAddExistingRouteToRouteMap() {
        // setup
        TestableApp app = new TestableApp();
        HttpMethod method = HttpMethod.GET;
        String endpoint = "login";
        app.addRoute(endpoint, method);

        // action
        app.addRoute(endpoint, method);

        // verify
        Map<String, Route> routeMap = app.getRouteMap();
        Assertions.assertNotNull(routeMap);
        Assertions.assertTrue(routeMap.containsKey(endpoint));
        Assertions.assertEquals(1, routeMap.size());
    }

    @Test
    void testCreateReturnsAppInstance() {
        // setup
        App app = App.create();

        // verify
        Assertions.assertNotNull(app);
    }

    @Test
    void testCreateReturnsOnlyOneInstance() {
        // setup
        App app = App.create();
        App app1 = App.create();

        // verify
        Assertions.assertSame(app, app1);
    }

    @Test
    void testAddHtmlPage_addsHtmlPageToMap() {
        // setup
        App app = new TestableApp();
        HtmlFactory factory = new HtmlFactory();
        String title = "Home Page";

        // action
        app.addHtmlPage(factory.createHomePage(), title);

        // verify
        Map<String, HtmlPages> htmlPageMap = app.getHtmlPageMap();
        Assertions.assertNotNull(htmlPageMap);
        Assertions.assertTrue(htmlPageMap.containsKey(title));
    }

    @Test
    void testAddHtmlPage_setsHtmlPageAndTitle() {
        // setup
        App app = new TestableApp();
        HtmlFactory factory = new HtmlFactory();
        String title = "Home Page";

        // action
        app.addHtmlPage(factory.createHomePage(), title);

        Map<String, HtmlPages> htmlPageMap = app.getHtmlPageMap();
        HtmlPages page = htmlPageMap.get(title);

        // verify
        Assertions.assertNotNull(page);
        Assertions.assertEquals(title, page.getTitle());
    }

    @Test
    void testAddHtmlPage_handlesNullHtmlPage() {
        // setup
        App app = new TestableApp();
        String title = "Home Page";

        // action
        app.addHtmlPage(null, title);

        // verify
        Map<String, HtmlPages> htmlPageMap = app.getHtmlPageMap();
        Assertions.assertFalse(htmlPageMap.containsKey(title));
    }

    @Test
    void testAddCustomHtmlPage_AddsPageToHtmlPageMap() {
        // setup
        App app = new TestableApp();
        String htmlPage = getBuilderResults();

        // action
        app.addCustomHtmlPage(htmlPage);

        // verify
        Map<String, HtmlPages> htmlPageMap = app.getHtmlPageMap();
        Assertions.assertNotNull(htmlPageMap);
        Assertions.assertTrue(htmlPageMap.containsKey("Custom Page"));
    }

    @Test
    void testAddCustomHtmlPage_SetsCustomPage() {
        // setup
        TestableApp app = new TestableApp();
        String htmlPage = getBuilderResults();

        // action
        app.addCustomHtmlPage(htmlPage);

        // verify
        Assertions.assertEquals(htmlPage, app.getCustomPage());
    }

    @Test
    void testAddCustomHtmlPage_HtmlPageMapDoesNotContainNullValue() {
        // setup
        App app = new TestableApp();
        String htmlPage = getBuilderResults();

        // action
        app.addCustomHtmlPage(htmlPage);

        // verify
        Map<String, HtmlPages> htmlPageMap = app.getHtmlPageMap();
        Assertions.assertNotNull(htmlPageMap);
        Assertions.assertFalse(htmlPageMap.containsKey(null));
    }

    @Test
    void testAddResponseToPage_SetsResponse() {
        // setup
        TestableApp app = new TestableApp();
        String response = "This is a test response.";

        // action
        app.addResponseToPage(response);

        // verify
        Assertions.assertEquals(response, app.getResponse());
    }

    @Test
    void testAddResponseToPage_AddsToHtmlPageMap() {
        // setup
        App app = new TestableApp();
        String response = "This is a test response.";

        // action
        app.addResponseToPage(response);

        // verify
        Map<String, HtmlPages> htmlPageMap = app.getHtmlPageMap();
        Assertions.assertTrue(htmlPageMap.containsKey(response));
    }

    @Test
    void testAddController_SetsController() {
        // setup
        TestableApp app = new TestableApp();
        Controller controller = new MyController("/hello");

        // action
        app.addController(controller);

        // verify
        Assertions.assertEquals(controller, app.getController());
    }

    @Test
    void testAddController_OverwritesExistingController() {
        // setup
        TestableApp app = new TestableApp();
        Controller initialController = new MyController("/hello");
        Controller newController = new MyController("/New");
        app.addController(initialController);

        // action
        app.addController(newController);

        // verify
        Assertions.assertEquals("/New", app.getController().getEndpoint());
    }

    @Test
    void testAddController_NullControllerThrowsException() {
        // setup
        App app = new TestableApp();

        // verify
        Assertions.assertThrows(NullPointerException.class, () -> app.addController(null));
    }

    @Test
    void testRun() {
        // setup
        MockApp app = new MockApp();

        // action
        app.run();

        // verify
        assertTrue(app.isRunMethodCalled());
    }

    private String getBuilderResults() {
        HtmlPageBuilder builder = new HtmlPageBuilder();
        builder.addHeader("Test of custom pages");
        builder.addNavElements("home", "about", "contact");
        return builder.build();
    }
}
