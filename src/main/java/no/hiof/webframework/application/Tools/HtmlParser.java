package no.hiof.webframework.application.Tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;

/**
 * HtmlParser is a utility class for parsing HTML pages.
 */
public class HtmlParser
{
    /**
     * Returns the title of an HTML page given an InputStream.
     * @param stream the InputStream of the HTML page
     * @return the title of the HTML page
     */
    public static String getTitleFromHtmlPage(InputStream stream) {
        String title = "";
        try {
            Document document = Jsoup.parse(stream, null, "");
            title = document.title();
        }
        catch (IOException ioException) {
            System.out.println("Failed to parse the file: " + ioException.getMessage());
        }
        return title;
    }

    /**
     * Returns the title of a custom HTML page given an HTML string.
     * @param html the custom HTML page as a String
     * @return the title of the custom HTML page
     */
    public static String readCustomHtmlPage(String html) {
        String title = "";
        Document document = Jsoup.parse(html);
        title = document.title();

        return title;

    }
}
