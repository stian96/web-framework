package no.hiof.webframework.Servlet.Default;
import no.hiof.webframework.Frontend.HtmlPages;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

public class LoginServlet extends AbstractServlet {

    public LoginServlet(HtmlPages page, String title) {
        super(page, title);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    }

    @Override
    protected InputStream getPageContent() {
        return getPage().getLoginPage();
    }
}