package no.hiof.webframework.Interface.Builders;

import java.util.List;

public interface IHtmlBuilder {
    void addHeader(String header);
    void addNavElements(String... args);
    void addMainSection(String header, String paragraph);
    void addImage(String imageUrl, String altText);
    void addLink(String url, String text);
    void addTable(List<List<String>> rows);

    void addFooterSection(String address, String phoneNumber, String email);
    String build();
}
