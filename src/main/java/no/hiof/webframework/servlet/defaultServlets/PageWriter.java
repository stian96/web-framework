package no.hiof.webframework.servlet.defaultServlets;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * This class provides a method to write an HTML page to an HTTP response.
 * <p>
 * @author Stian Rusvik.
 */
class PageWriter {
    /**
     * Writes an HTML page to an HTTP response.
     * @param inputStream the input stream containing the HTML page content
     * @param response the HTTP servlet response to write the page to
     * @param title the title to be displayed on the page
     */
    protected static void writePage(InputStream inputStream, HttpServletResponse response, String title) {
        try {
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                PrintWriter writer = response.getWriter();

                if (title != null)
                    writer.println("<h1 style='text-align: center; color: slategray;'>" + title + "</h1>");
                else
                    writer.println("<title>" + response + "</title>");

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.println(line);
                }
            }
        }
        catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

    }
}
