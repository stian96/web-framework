package no.hiof.webframework.Application;
import no.hiof.webframework.Application.Routes.Route;
import no.hiof.webframework.Controllers.Controller;
import no.hiof.webframework.Exceptions.NoHtmlContentException;
import no.hiof.webframework.Frontend.HtmlPages;
import no.hiof.webframework.Servlet.ApplicationServlet;
import no.hiof.webframework.Servlet.CustomServlet;
import no.hiof.webframework.Servlet.Default.HomeServlet;
import no.hiof.webframework.Servlet.Default.LoginServlet;
import no.hiof.webframework.Servlet.Default.LogoutServlet;
import no.hiof.webframework.Servlet.DefaultServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.Map;

class ServerHandler {
    private String applicationTitle;
    private Controller controller;

    protected ServerHandler(String title) {
        this.applicationTitle = title;
    }

    protected ServerHandler(Controller controller) {
        this.controller = controller;
    }

    protected ServerHandler() {}

    protected void initializeHandler(Server server, App app) {
        try {
            ServletContextHandler context = new ServletContextHandler();
            context.setContextPath("/");
            addServletToContext(context, app);

            if (applicationTitle != null) {
                ApplicationServlet.setApplicationTitle(applicationTitle);
                context.addServlet(ApplicationServlet.class, "/");
            }
            if (controller != null) {
                context.addServlet(new ServletHolder(controller), "/" + controller.getEndpoint());
            }

            server.setHandler(context);
            startServer(server);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private void addServletToContext(ServletContextHandler context, App app) throws NoHtmlContentException {
        for (Map.Entry<String, Route> entry : app.getRouteMap().entrySet()) {
            Route route = entry.getValue();
            String uri = "/" + route.getRoute() + "/*";
            String keySet = app.getHtmlPageMap().keySet().toString();

            if (!checkForHtmlPage(app)) {
                addServletIfNeeded(keySet, uri, context, app);
                app.titleCounter++;
            }
            else {
                throw new NoHtmlContentException("Need to add html pages to the application.");
            }
        }
    }

    private void addServletIfNeeded(String titleSet, String uri, ServletContextHandler context, App app) {
        String [] titles = mapSetToArray(titleSet);

        if (app.titleCounter <= app.getHtmlPageMap().size() - 1) {
            HtmlPages page = app.getHtmlPageMap().get(titles[app.titleCounter].trim());
            ServletHolder servlet = getServlet(titles[app.titleCounter].trim(), page, app);
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

    private ServletHolder getServlet(String title, HtmlPages page, App app) {
        switch (title) {
            case "Login Page": return new ServletHolder(new LoginServlet(page, page.getTitle()));
            case "Home Page": return new ServletHolder(new HomeServlet(page, page.getTitle()));
            case "Logout Page": return new ServletHolder(new LogoutServlet(page, page.getTitle()));
            case "Custom Page": {
                if (app.getDbUser() != null) {
                    return new ServletHolder(new CustomServlet(app.getCustomPage(), app.getDbUser()));
                }
                else {
                    return new ServletHolder(new CustomServlet(app.getCustomPage()));
                }
            }
            default: return new ServletHolder(new DefaultServlet(app.getResponse()));
        }
    }

    private boolean checkForHtmlPage(App app) {
        return app.getHtmlPageMap().size() == 0;
    }

    private void startServer(Server server) throws Exception {
        server.start();
        server.join();
    }

    public void setTitle(String title) {
        this.applicationTitle = title;
    }
}
