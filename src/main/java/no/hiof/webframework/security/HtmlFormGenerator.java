package no.hiof.webframework.security;
//Scenario 3.1

public class HtmlFormGenerator {
    /**
     * Method to generate a login-form using HTML.
     * */
    protected String generateLoginForm () {
        //Skjema
        String html = "<form>";
        html += "<label for=\"username\">Brukernavn:</label>";
        html += "<input type=\"text\" id=\"username\" name=\"username\"><br>";
        html += "<label for=\"password\">Passord:</label>";
        html += "<input type=\"password\" id=\"password\" name=\"password\"><br>";
        html += "</form>";
        return html;
    }

    /**
     * Method to generate HTML-page for the login-form.
     * */
    protected String generateHtmlPageWithLoginForm(){
        String htmlPage = "<html>";
        htmlPage += "<head>";
        htmlPage += "<title>Login Page</title>";
        htmlPage += "</head>";
        htmlPage += "<body>";
        htmlPage += generateLoginForm();
        htmlPage += "</body>";
        htmlPage += "</html>";

        return htmlPage;

    }

}
