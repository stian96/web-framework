package no.hiof.webframework.Interface.Builders;

import no.hiof.webframework.Exceptions.HttpMethodException;
import org.eclipse.jetty.http.HttpMethod;

import java.util.List;

public interface IHtmlBuilder {
    void addHeader(String header);
    void addNavElements(String... args);
    void addMainSection(String header, String paragraph);
    void addForm(HttpMethod method, String... fields) throws HttpMethodException;
    void addImage(String imageUrl, String altText);
    void addLink(String url, String text);
    void addTable(List<List<String>> rows);

    void addFooterSection(String address, String phoneNumber, String email);
    String build();
}
