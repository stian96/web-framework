package no.hiof.webframework.Data;

public class LoginData {
    static String username;
    static String password;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String name) {
        username = name;
    }

    public String getPassword() {
        return password;
    }

    public static void setPassword(String pass) {
        password = pass;
    }
}
