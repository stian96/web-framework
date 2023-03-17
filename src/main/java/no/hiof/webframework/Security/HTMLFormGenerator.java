package no.hiof.webframework.Security;
//Scenario 3.1
public class HTMLFormGenerator {
    /**
     * Method to generate a login form using HTML.
     * */
    public String generateLoginFormHTML () {
        String html = "<form>";
        html += "<label for=\"username\">Brukernavn:</label>";
        html += "<input type=\"text\" id=\"username\" name=\"username\"><br>";
        html += "<label for=\"password\">Passord:</label>";
        html += "<input type=\"password\" id=\"password\" name=\"password\"><br>";
        html += "</form>";
        return html;
    }
}
