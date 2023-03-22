package no.hiof.webframework.Interface;

import org.eclipse.jetty.http.HttpMethod;

/**
 * This is an interface for defining a route in a web application.
 * It defines methods to retrieve the route path and HTTP method.
 */
public interface IRoute {
    /**
     * Returns the route path for this route.
     * @return The route path as a string.
     */
    String getRoute();

    /**
     * Returns the HTTP method for this route.
     * @return The HTTP method for this route.
     */
    HttpMethod getHttpMethod();
}
