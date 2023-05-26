package no.hiof.webframework.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class RepositoryConnection {
    protected String url;
    protected String username;
    protected String password;
    protected String schemaName;
    protected Connection connection;

    public RepositoryConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            connection = createConnection();
            System.out.println("Connected to database.");
        } catch (Exception e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
    public void connect(String schemaName) {
        try {

            this.schemaName = schemaName;
            connection = createConnection(schemaName);
            System.out.println("Connected to database with schema name: " + schemaName);
        } catch (Exception e) {
            System.err.println("Error connecting to the database with schema name: " + schemaName + " - " + e.getMessage());
        }
    }
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from database.");
            }
        } catch (Exception e) {
            System.err.println("Error disconnecting from the database: " + e.getMessage());
        }
    }

    protected abstract Connection createConnection();
    protected abstract Connection createConnection(String schemaName);

    protected String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}