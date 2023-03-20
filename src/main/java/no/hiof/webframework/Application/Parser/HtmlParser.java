package no.hiof.webframework.Application.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    public static String readCustomHtmlPage(String html) {
        String title = "";
        Document document = Jsoup.parse(html);
        title = document.title();

        return title;

    }
}
