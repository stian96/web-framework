package no.hiof.webframework.security;

/**
 * Utility class for generating HTML forms.
 */
public class HtmlFormGenerator {

    /**
     * Generates a login form using HTML.
     *
     * @return the HTML representation of the login form
     */
    public String generateLoginForm() {
        String htmlLoginForm = "<form>";
        htmlLoginForm += "<label for=\"username\">Enter your username:</label>";
        htmlLoginForm += "<input type=\"text\" id=\"username\" name=\"username\"><br>";
        htmlLoginForm += "<label for=\"password\">Enter your password:</label>";
        htmlLoginForm += "<input type=\"password\" id=\"password\" name=\"password\"><br>";
        htmlLoginForm += "</form>";
        return htmlLoginForm;
    }

    /**
     * Generates an HTML page that includes the login form.
     *
     * @return the HTML representation of the login page
     */
    public String generateHtmlPageWithLoginForm() {
        String htmlLoginPage = "<html>";
        htmlLoginPage += "<head>";
        htmlLoginPage += "<title>Login Page</title>";
        htmlLoginPage += "</head>";
        htmlLoginPage += "<body>";
        htmlLoginPage += generateLoginForm();
        htmlLoginPage += "</body>";
        htmlLoginPage += "</html>";
        return htmlLoginPage;
    }
}
