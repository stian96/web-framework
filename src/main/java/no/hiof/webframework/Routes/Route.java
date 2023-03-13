package no.hiof.webframework.Routes;

import no.hiof.webframework.Interface.IRoute;

public class Route implements IRoute {
    private final String endpoint;
    private final String title;

    public Route(String endpoint, String title) {
        this.endpoint = endpoint;
        this.title = title;
    }

    @Override
    public String getRoute() {
        return endpoint;
    }
    @Override
    public String getTitle() {
        return title;
    }
}
