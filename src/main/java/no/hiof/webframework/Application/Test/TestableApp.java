package no.hiof.webframework.Application.Test;

import no.hiof.webframework.Application.App;
import no.hiof.webframework.Application.Routes.Route;
import no.hiof.webframework.Controllers.Controller;

import java.util.Map;

public class TestableApp extends App {
    @Override
    public String getResponse() {
        return super.getResponse();
    }

    @Override
    public Map<String, Route> getRouteMap() {
        return super.getRouteMap();
    }

    @Override
    public Controller getController() {
        return super.getController();
    }

}
