package no.hiof.webframework.security;

public class HtmlFormGenerator {
    /**
     * Method to generate a login-form using HTML.
     * */
    public String generateLoginForm () {
        String htmlLoginForm = "<form>";
        htmlLoginForm += "<label for=\"username\">Enter your username:</label>";
        htmlLoginForm += "<input type=\"text\" id=\"username\" name=\"username\"><br>";
        htmlLoginForm += "<label for=\"password\">Enter your password:</label>";
        htmlLoginForm += "<input type=\"password\" id=\"password\" name=\"password\"><br>";
        htmlLoginForm += "</form>";
        return htmlLoginForm;
    }

    /**
     * Method to generate HTML-page including the method 'generateLoginForm' to access a login-form.
     * */
    public String generateHtmlPageWithLoginForm(){
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

//Kilde: Priyarajtt. (u.å).Servlet – Login Form. Hentet fra geeksforgeeks:
//https://www.geeksforgeeks.org/servlet-login-form/
