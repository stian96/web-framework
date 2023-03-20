package no.hiof.webframework.Application.Routes;

import no.hiof.webframework.Interface.IRoute;
import org.eclipse.jetty.http.HttpMethod;

public class Route implements IRoute {
    private final String endpoint;
    private final HttpMethod httpMethod;

    public Route(String endpoint, HttpMethod httpMethod) {
        this.endpoint = endpoint;
        this.httpMethod = httpMethod;
    }

    @Override
    public String getRoute() {
        return endpoint;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }
}
