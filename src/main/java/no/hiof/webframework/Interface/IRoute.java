package no.hiof.webframework.Interface;

import org.eclipse.jetty.http.HttpMethod;

public interface IRoute {
    String getRoute();
    HttpMethod getHttpMethod();
}
