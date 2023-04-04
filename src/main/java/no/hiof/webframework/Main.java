package no.hiof.webframework;

import no.hiof.webframework.Servlet.ChatRoomServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class Main {
    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");

        ServletHandler servletHandler = new ServletHandler();
        context.setServletHandler(servletHandler);

        servletHandler.addServletWithMapping(new ServletHolder(new ChatRoomServlet()), "/chat");
        System.out.println("Listen on: http://localhost:8080/chat");

        server.setHandler(context);
        server.start();
        server.join();

    }
}