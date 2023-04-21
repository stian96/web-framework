package no.hiof.webframework.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**

 The SqlConnection class implements the RepositoryConnection interface and provides a concrete implementation of a
 database connection for SQL databases. It uses JDBC drivers to connect to the database and provides methods for
 connecting and disconnecting from the database.
 */
public class RepositoryConnection {

    private static RepositoryConnection instance = null;
    private String url;
    private String username;
    private String password;

    private String schemaName;
    private Connection connection;

    /**

     * Sets the URL, username, and password for connecting to the database.
     * @param url the URL of the database
     * @param username the username for accessing the database
     * @param password the password for accessing the database
     */

    public void addRepositoryDetails(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;

    }

    /**

    * Creates a new instance of RepositoryConnection if none exists, and returns the instance.
    * @return the singleton instance of RepositoryConnection
     */
    public static RepositoryConnection create(){
        if(instance == null){
            instance = new RepositoryConnection();
        }
        return instance;
    }
    /**

     * This method connects to the database using the specified URL, username, and password.
     * If the connection is successful, a message is printed to the console indicating that the connection was successful.
     * If an error occurs while connecting to the database, an error message is printed to the console with details of the error.
     */
    public void connect() {
        try {

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database.");
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }

    }

    /**
     * This method establishes a connection to a database with a specified schema name using the URL,
     * username, and password provided by the addRepositoryDetails() method.
     * @param schemaName the name of the schema to connect to
     */
    public void connect(String schemaName) {
        try {
            String urlWithSchema = url  + schemaName;
            this.schemaName = schemaName;
            connection = DriverManager.getConnection(urlWithSchema, username, password);
            System.out.println("Connected to database with schema name: " + schemaName);
        } catch (SQLException e) {
            System.err.println("Error connecting to the database with schema name: " + schemaName + " - " + e.getMessage());
        }
    }

    /**
     * Disconnects from the database
     */

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from database.");
            }
        } catch (SQLException e) {
            System.err.println("Error disconnecting from database: " + e.getMessage());
        }
    }

    /**

     * This method returns the established database connection.
     * If the connection has not been established, an IllegalStateException is thrown.
     * @return the established database connection
     * @throws IllegalStateException if the connection has not been established
     */
    public Connection getConnection() {
        if (connection == null) {
            throw new IllegalStateException("Database connection not established.");
        }
        return connection;

    }
    public RepositoryConnection getInstance() {
        return instance;
    }

    protected String getUrl() {
        return url;
    }

    protected String getUsername() {
        return username;
    }

    protected String getPassword() {
        return password;
    }



    private static void setInstance(RepositoryConnection instance) {
        RepositoryConnection.instance = instance;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected RepositoryConnection() {

    }

    protected String getSchemaName() {
        return schemaName;
    }

    private void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

}
