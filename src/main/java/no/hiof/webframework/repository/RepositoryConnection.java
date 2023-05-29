package no.hiof.webframework.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* An abstract class that represents a connection to a repository or database.
 **/
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

    /**
     * Establishes a connection to the database using the provided credentials.
     */
    public void connect() {
        try {
            connection = createConnection();
            System.out.println("Connected to database.");
        } catch (Exception e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }

    /**
     * Establishes a connection to the database with the specified schema name.
     * @param schemaName name of the specified schema to connect to.
     */
    public void connect(String schemaName) {
        try {

            this.schemaName = schemaName;
            connection = createConnection(schemaName);
            System.out.println("Connected to database with schema name: " + schemaName);
        } catch (Exception e) {
            System.err.println("Error connecting to the database with schema name: " + schemaName + " - " + e.getMessage());
        }
    }

    /**
     * Closes the database connection.
     */
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

    /**
     * An abstract method that needs to be implemented by the subclasses.
     * It creates and returns a 'Connection' object specific to the database being used.
     * @return Connection object
     */
    protected abstract Connection createConnection();

    /**
     * An abstract method that needs to be implemented by the subclasses.
     * It creates and returns a 'Connection' object specified to the database and
     * schema being used.
     * @param schemaName schema to connect to
     * @return Connection object
     */
    protected abstract Connection createConnection(String schemaName);

    protected String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    protected String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    protected String getPassword() {
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

    protected String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }
}