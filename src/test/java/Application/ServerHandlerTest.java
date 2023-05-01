package Application;
import Application.TestClasses.TestableApp;
import Application.TestClasses.TestableServerHandler;
import no.hiof.webframework.application.App;
import no.hiof.webframework.application.frontend.HtmlFactory;
import no.hiof.webframework.application.frontend.HtmlPages;
import no.hiof.webframework.application.routes.Route;
import no.hiof.webframework.Exceptions.NoHtmlContentException;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class ServerHandlerTest {

    @Test
    void testThatInitializeHandlerInitializeServer() {
        // setup
        Server serverMock = Mockito.mock(Server.class);
        App appMock = Mockito.mock(App.class);
        TestableServerHandler handler = new TestableServerHandler();

        // act
        handler.initializeHandler(serverMock, appMock);

        // Assert
        Assertions.assertTrue(handler.startServerCalled);
    }

    @Test
    void testAddServletToContext() throws Exception {
        // setup
        ServletContextHandler contextMock = Mockito.mock(ServletContextHandler.class);
        TestableApp appMock = Mockito.mock(TestableApp.class);
        HtmlFactory factory = new HtmlFactory();
        HtmlPages pages = new HtmlPages();

        // stubbing
        Map<String, Route> routeMap = new HashMap<>();
        Route route1 = new Route("testRoute", HttpMethod.GET);
        routeMap.put("testRoute", route1);
        when(appMock.getRouteMap()).thenReturn(routeMap);

        Map<String, HtmlPages> htmlPageMap = new HashMap<>();
        pages.setHtmlPage(factory.createHomePage());
        pages.setTitle("Title1");
        htmlPageMap.put("Title1", pages);
        when(appMock.getHtmlPageMap()).thenReturn(htmlPageMap);

        TestableServerHandler handler = new TestableServerHandler();

        // act
        handler.addServletToContext(contextMock, appMock);

        // assert
        verify(contextMock, times(1)).addServlet(any(ServletHolder.class), eq("/testRoute/*"));
    }

    @Test
    void testAddServletToContextThrowsNoHtmlContentException() {

        // setup
        ServletContextHandler contextMock = Mockito.mock(ServletContextHandler.class);
        TestableApp appMock = Mockito.mock(TestableApp.class);

        // stubbing
        Map<String, Route> routeMap = new HashMap<>();
        Route route1 = new Route("testRoute", HttpMethod.GET);
        routeMap.put("testRoute", route1);
        when(appMock.getRouteMap()).thenReturn(routeMap);

        TestableServerHandler handler = new TestableServerHandler();

        // act
        assertThrows(NoHtmlContentException.class, () -> handler.addServletToContext(contextMock, appMock));
    }

    @Test
    void testThatSetTitleSetsTheTitleOfThePage() {

        // setup
        TestableServerHandler handler = new TestableServerHandler();

        // act
        handler.setTitle("My title");

        // Assert
        Assertions.assertEquals("My title", handler.getTitle());
    }
}

