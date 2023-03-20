package no.hiof.webframework.Interface;

public interface IHtmlBuilder {
    void addHeader(String header);
    void addNavElements(String... args);
    void addMainSection(String header, String paragraph);
    void addFooterSection(String address, String phoneNumber, String email);
}
