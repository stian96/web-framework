package no.hiof.webframework.Interface;

public interface HtmlTemplate {
    void addNavElements(String... args);
    void addMainSection(String header, String paragraph);
    void addFooterSection(String address, String phoneNumber, String email);
}
