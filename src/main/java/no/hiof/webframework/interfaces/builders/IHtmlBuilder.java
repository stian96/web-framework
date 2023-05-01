package no.hiof.webframework.interfaces.builders;

import no.hiof.webframework.exceptions.HttpMethodException;
import org.eclipse.jetty.http.HttpMethod;

import java.util.List;

/**
 * This is an interface for building an HTML page. It defines methods for adding different sections to the page and
 * building the final HTML page.
 */
public interface IHtmlBuilder {
    /**
     * Adds a header section to the HTML page.
     * @param header The header text to add.
     */
    void addHeader(String header);

    /**
     * Adds navigation elements to the HTML page.
     * @param args The navigation elements to add.
     */
    void addNavElements(String... args);

    /**
     * Adds a main section to the HTML page.
     * @param header The header text for the main section.
     * @param paragraph The paragraph text for the main section.
     */
    void addMainSection(String header, String paragraph);

    /**
     * Adds a form section to the HTML page.
     * @param method The HTTP method for the form.
     * @param fields The form fields to add.
     * @throws HttpMethodException If an invalid HTTP method is specified.
     */
    void addForm(HttpMethod method, String... fields) throws HttpMethodException;

    /**
     * Adds an image to the HTML page.
     * @param imageUrl The URL of the image.
     * @param altText The alternative text for the image.
     */
    void addImage(String imageUrl, String altText);

    /**
     * Adds a link to the HTML page.
     * @param url The URL of the link.
     * @param text The text to display for the link.
     */
    void addLink(String url, String text);

    /**
     * Adds a table to the HTML page.
     * @param rows The rows of the table.
     */
    void addTable(List<List<String>> rows);

    /**
     * Adds a footer section to the HTML page.
     * @param address The address for the footer section.
     * @param phoneNumber The phone number for the footer section.
     * @param email The email for the footer section.
     */
    void addFooterSection(String address, String phoneNumber, String email);

    /**
     * Builds the HTML page as a string.
     * @return The built HTML page as a string.
     */
    String build();
}
