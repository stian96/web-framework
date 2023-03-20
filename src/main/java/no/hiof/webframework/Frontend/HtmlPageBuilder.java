package no.hiof.webframework.Frontend;

import no.hiof.webframework.Interface.IHtmlBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Uses the Builder pattern to create custom html pages.
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

    @Override
    public void addHeader(String header) {
        String headerContent = "<h1>" + header + "</h1>";
        content.replace(
                content.indexOf("<!--HEADER_PLACEHOLDER-->"),
                content.indexOf("<!--HEADER_PLACEHOLDER-->") + "<!--HEADER_PLACEHOLDER-->".length(),
                headerContent.toString());

    }

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

    @Override
    public void addMainSection(String header, String paragraph) {
        String mainContent = "<h1>" + header + "</h1>" + "<p>" + paragraph + "</p>";
        content.replace(
                content.indexOf("<!--MAIN_PLACEHOLDER-->"),
                content.indexOf("<!--MAIN_PLACEHOLDER-->") + "<!--MAIN_PLACEHOLDER-->".length(),
                mainContent);
    }

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

    public String build() {
        return content.toString();
    }
}
