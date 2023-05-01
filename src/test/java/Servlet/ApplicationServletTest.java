package Servlet;

import no.hiof.webframework.servlet.ApplicationServlet;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import static org.mockito.Mockito.*;

public class ApplicationServletTest {


    @Test
    public void testDoGetOnSuccess() throws Exception {

        // Setup
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(response.getWriter()).thenReturn(writer);

        // Test
        ApplicationServlet applicationServlet = new ApplicationServlet();
        ApplicationServlet.setApplicationTitle("My Application");
        applicationServlet.doGet(request, response);

        // Verify
        verify(response, atLeastOnce()).setContentType("text/html");
        verify(writer, atLeastOnce()).println("<html><body><h1>My Application</h1></body></html>");
    }
}
