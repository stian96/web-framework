package no.hiof.webframework.Application.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;

public class HtmlParser
{
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
}
