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
    void testAddHtmlPage_addsHtmlPageToMap() {
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

    @Test
    void testAddHtmlPage_setsHtmlPageAndTitle() {
        // setup
        App app = new App();
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
        App app = new App();
        String title = "Home Page";

        // action
        app.addHtmlPage(null, title);

        // verify
        Map<String, HtmlPages> htmlPageMap = app.getHtmlPageMap();
        Assertions.assertFalse(htmlPageMap.containsKey(title));
    }
}
