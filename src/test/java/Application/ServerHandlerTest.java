package Application;

import Application.TestClasses.TestableServerHandler;
import no.hiof.webframework.Application.App;
import org.eclipse.jetty.server.Server;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
}

