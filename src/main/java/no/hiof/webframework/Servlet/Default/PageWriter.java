package no.hiof.webframework.Servlet.Default;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

class PageWriter {

    protected static void writePage(InputStream inputStream, HttpServletResponse response, String title) throws IOException {
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
}
