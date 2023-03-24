package Application;

import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Frontend.HtmlFactory;
import no.hiof.webframework.Application.Frontend.HtmlPages;
import org.eclipse.jetty.http.HttpMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class AppTest {

    @Test
    void testAddRouteAddsRouteToRouteMap() {
        // setup
        App app = new App();
        HttpMethod method = HttpMethod.GET;
        String endpoint = "login";

        // action
        app.addRoute(endpoint, method);

        // verify
        Assertions.assertNotNull(app.getRouteMap());
        assertTrue(app.getRouteMap().containsKey("login"));
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
    void testAddHtmlPage() {
        // setup
        App app = new App();
        HtmlFactory factory = new HtmlFactory();
        String title = "Home Page";

        // action
        app.addHtmlPage(factory.createHomePage(), title);

        // verify
        Map<String, HtmlPages> htmlPageMap = app.getHtmlPageMap();
        Assertions.assertNotNull(htmlPageMap);
        Assertions.assertTrue(htmlPageMap.containsKey(title));
    }

    // TODO: Add more tests for App-class.
}
