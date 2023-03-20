package no.hiof.webframework.Frontend;

import no.hiof.webframework.Interface.HtmlTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomHtmlPage implements HtmlTemplate {
    private final StringBuilder content  = new StringBuilder();

    public CustomHtmlPage() {
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
    public void addNavElements(String... navElements) {
        StringBuilder navContent = new StringBuilder();
        navContent.append("<nav>");
        navContent.append("<ul>");
        for (String element : navElements) {
            navContent.append("<li>").append(element).append("</li>");
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
        String contactInfo = "<footer><div class='contact-info'>" +
                "<p>" + address + "</p>" +
                "<p>" + phoneNumber + "</p>" +
                "<p>" + email + "</p>" +
                "</div></footer>";

        content.replace(
                content.indexOf("<!--FOOTER_PLACEHOLDER-->"),
                content.indexOf("<!--FOOTER_PLACEHOLDER-->") + "<!--FOOTER_PLACEHOLDER-->".length(),
                contactInfo);
    }

    public String getContent() {
        return content.toString();
    }
}
