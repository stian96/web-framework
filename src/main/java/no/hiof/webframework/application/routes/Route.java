package no.hiof.webframework.application.routes;

import no.hiof.webframework.interfaces.IRoute;
import org.eclipse.jetty.http.HttpMethod;

/**
 * Route is a class that implements the IRoute interface and represents an HTTP endpoint.
 * It takes an endpoint and an HTTP method as parameters in the constructor.
 * <p>
 * @author Stian Rusvik.
 */
public class Route implements IRoute {
    private final String endpoint;
    private final HttpMethod httpMethod;

    public Route(String endpoint, HttpMethod httpMethod) {
        this.endpoint = endpoint;
        this.httpMethod = httpMethod;
    }

    /**
     * Returns the endpoint of the route.
     * @return the HTTP endpoint
     */
    @Override
    public String getRoute() {
        return endpoint;
    }

    /**
     * Returns the HTTP method of the route.
     * @return the HTTP method
     */
    @Override
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }
}
