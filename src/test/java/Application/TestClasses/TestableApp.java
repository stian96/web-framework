package Application.TestClasses;

import no.hiof.webframework.application.App;
import no.hiof.webframework.application.routes.Route;
import no.hiof.webframework.controllers.Controller;

import java.util.Map;

/**
 * Class used for testing purposes of the App class.
 */
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

    @Override
    public String getCustomPage() {
        return super.getCustomPage();
    }

    @Override
    public int getPageCounter() {return super.getPageCounter(); }

    @Override
    public void incrementPageCounter() { super.incrementPageCounter();}
}
