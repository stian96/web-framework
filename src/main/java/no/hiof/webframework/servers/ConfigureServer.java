package no.hiof.webframework.servers;

import no.hiof.webframework.exceptions.EndpointException;
import no.hiof.webframework.exceptions.PortNumberException;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;

public class ConfigureServer {
    private ServletContextHandler contextHandler = null;
    private ResourceHandler resourceHandler = null;
    private HandlerList handlerList = null;
    private Server server = null;

    // Constructor made private to prevent direct instantiation.
    private ConfigureServer() {}

    // Inner class used to build the configurations.
    public static class Builder {
        private int portNumber = 0;
        private String serverEndpoint;
        private HttpServlet controller;
        private String controllerEndpoint;
        private String staticResourceFilename;
        private String staticResourceFolder;

        public Builder setPortNumber(int portNumber) {
            this.portNumber = portNumber;
            return this;
        }

        public Builder setServerEndpoint(String serverEndpoint) {
            this.serverEndpoint = serverEndpoint;
            return this;
        }

        public Builder addController(HttpServlet controller, String controllerEndpoint) {
            this.controller = controller;
            this.controllerEndpoint = controllerEndpoint;
            return this;
        }

        public Builder addStaticResources(String filename, String absPathToFolder) {
            this.staticResourceFilename = filename;
            this.staticResourceFolder = absPathToFolder;
            return this;
        }

        public ConfigureServer build() {
            ConfigureServer configureServer = new ConfigureServer();
            configureServer.setPortNumber(this.portNumber);
            configureServer.setServerEndpoint(this.serverEndpoint);
            configureServer.addControllerToServer(this.controller, this.controllerEndpoint);
            configureServer.addStaticResources(this.staticResourceFilename, this.staticResourceFolder);

            return configureServer;
        }
    }

    private void setPortNumber(int number)
    {
        try
        {
            if (number == 0)
                throw new Exception();
            else
                server = new Server(number);
        }
        catch (Exception e)
        {
            System.err.println("Exception: Set port number before calling build method.");
            stop();
        }
    }

    private void setServerEndpoint(String endpoint)
    {
        try
        {
            contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
            contextHandler.setContextPath(endpoint);
        }
        catch (IllegalArgumentException i)
        {
            System.err.println("EndpointException: Set server endpoint before calling build method.");
            stop();
        }
    }

    private void addControllerToServer(HttpServlet controller, String controllerEndpoint)
    {
        try
        {
            if (contextHandler == null)
                throw new EndpointException();
            else
                contextHandler.addServlet(new ServletHolder(controller), controllerEndpoint);
        }
        catch (EndpointException e)
        {
            System.err.println("EndpointException: " + e.getMessage());
            stop();
        }
    }

    private void addStaticResources(String filename, String absPathToFolder)
    {
        resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[] {filename});
        resourceHandler.setResourceBase(absPathToFolder);
    }

    private void activateHandler()
    {
        handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[] {resourceHandler, contextHandler});
    }

    public void startServer() {
        try
        {
            if (this.server == null)
            {
                throw new PortNumberException();
            }
            else if (contextHandler == null)
            {
                throw new EndpointException();
            }
            else
            {
                activateHandler();
                server.setHandler(handlerList);
                server.join();
                server.start();
            }
        }
        catch (InterruptedException i)
        {
            System.err.println("InterruptedException: " + i.getMessage());
            stop();
        }
        catch (PortNumberException p)
        {
            System.err.println("PortNumberException: " + p.getMessage());
            stop();
        }
        catch (EndpointException end)
        {
            System.err.println("EndpointException: " + end.getMessage());
            stop();
        }
        catch (Exception e)
        {
            System.err.println("Exception: Add 'static resources' before calling start server method.");
            stop();
        }
    }

    private void stop() {
        System.exit(1);
    }
}
