package no.hiof.webframework.Frontend;

import no.hiof.webframework.Interface.Builders.IHtmlBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Uses the Builder pattern to create custom html-pages.
 */
public class HtmlPageBuilder implements IHtmlBuilder {
    private final StringBuilder content  = new StringBuilder();

    public HtmlPageBuilder() {
        try {
            defaultCode();
        }
        catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    private void defaultCode() throws IOException {
        String filePath = "src/main/resources/Text/defaultHtml.txt";
        String fileContent = Files.readString(Paths.get(filePath));
        content.append(fileContent);
    }

    /**
     * Adds a header to the top of the page.
     * @param header The header as a string.
     */
    @Override
    public void addHeader(String header) {
        String headerContent = "<h1>" + header + "</h1>";
        content.replace(
                content.indexOf("<!--HEADER_PLACEHOLDER-->"),
                content.indexOf("<!--HEADER_PLACEHOLDER-->") + "<!--HEADER_PLACEHOLDER-->".length(),
                headerContent.toString());

    }

    /**
     * Adds a navigation menubar to the page.
     * @param navElements The elements to be displayed in the menubar.
     */
    @Override
    public void addNavElements(String... navElements) {
        StringBuilder navContent = new StringBuilder();
        navContent.append("<nav>");
        navContent.append("<ul>");
        for (String element : navElements) {
            navContent.append("<li>")
                    .append("<a href='#'>")
                    .append(element).append("</a>")
                    .append("</li>");
        }
        navContent.append("</ul>");
        navContent.append("</nav>");
        content.replace(
                content.indexOf("<!--NAV_PLACEHOLDER-->"),
                content.indexOf("<!--NAV_PLACEHOLDER-->") + "<!--NAV_PLACEHOLDER-->".length(),
                navContent.toString());
    }

    /**
     * Adds a main-section to the page that contains a header and a paragraph.
     * @param header The header to be displayed in the main-section.
     * @param paragraph The paragraph in the main-section.
     */
    @Override
    public void addMainSection(String header, String paragraph) {
        String mainContent = "<h1>" + header + "</h1>" + "<p>" + paragraph + "</p>";
        content.replace(
                content.indexOf("<!--MAIN_PLACEHOLDER-->"),
                content.indexOf("<!--MAIN_PLACEHOLDER-->") + "<!--MAIN_PLACEHOLDER-->".length(),
                mainContent);
    }

    @Override
    public void addImage(String imageUrl, String altText) {
        // Will be implemented later
    }

    @Override
    public void addLink(String url, String text) {
        // Will be implemented later

    }

    @Override
    public void addTable(List<List<String>> rows) {
        // Will be implemented later

    }

    /**
     * Adds a footer-section in the bottom of the page that contains contact information.
     * @param address Address of the user/company.
     * @param phoneNumber Phone number of the user/company.
     * @param email Email to the user/company.
     */
    @Override
    public void addFooterSection(String address, String phoneNumber, String email) {
        String contactInfo = "<footer>" +
                "<p>Address: " + address + "</p>" +
                "<p>Phone: " + phoneNumber + "</p>" +
                "<p>Email: " + email + "</p>" +
                "</footer>";

        content.replace(
                content.indexOf("<!--FOOTER_PLACEHOLDER-->"),
                content.indexOf("<!--FOOTER_PLACEHOLDER-->") + "<!--FOOTER_PLACEHOLDER-->".length(),
                contactInfo);
    }

    /**
     * When the page is finished, this method can be used to build the page.
     * @return The page as a String, which then should be passed as an argument
     * to the app.addCustomHtmlPage() method.
     */
    @Override
    public String build() {
        return content.toString();
    }
}
