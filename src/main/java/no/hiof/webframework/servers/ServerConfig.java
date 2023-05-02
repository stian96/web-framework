package no.hiof.webframework.servers;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;

public class ServerConfig {
    private static ServerConfig instance = null;
    private ServletContextHandler contextHandler;
    private ResourceHandler resourceHandler;

    private HandlerList handlerList;
    private Server server;


    public static ServerConfig getInstance()
    {
        if (instance == null)
        {
            instance = new ServerConfig();
        }
        return instance;
    }


    public void setPortNumber(int number)
    {
        server = new Server(number);
    }

    public void setServerEndpoint(String endpoint)
    {
        contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath(endpoint);
    }

    public void addControllerToServer(HttpServlet controller, String controllerEndpoint)
    {
        contextHandler.addServlet(new ServletHolder(controller), controllerEndpoint);
    }

    public void addStaticResource(String filename, String absPathToFolder)
    {
        resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[] {filename});
        resourceHandler.setResourceBase(absPathToFolder);
        activateHandler();
    }

    private void activateHandler()
    {
        handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[] {resourceHandler, contextHandler});
    }

    public void startServer() {
        try
        {
            server.setHandler(handlerList);
            server.join();
            server.start();
        }
        catch (InterruptedException i)
        {
            System.out.println("InterruptedException: " + i.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
