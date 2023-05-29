package repository;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repository.testClasses.TestRepositoryConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class RepositoryConnectionTest {
/*
    private TestRepositoryConnection connection;

    @Before
    public void setUp() {
        // Set up the test data
        String url = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "password";

        connection = new TestRepositoryConnection(url, username, password);
    }

    @After
    public void tearDown() {
        // Clean up resources
        if (connection != null) {
            connection.disconnect();
        }
    }

    @Test
    public void testConnect() {
        // Establish the connection
        connection.connect();

        // Verify the connection is not null
        Connection jdbcConnection = connection.getConnection();
        assertNotNull("The JDBC connection should not be null", jdbcConnection);

        try {
            // Perform a simple query to verify the connection
            try (Statement statement = jdbcConnection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT 1")) {

                // Verify the query result
                assertTrue("The result set should have at least one row", resultSet.next());
                int result = resultSet.getInt(1);
                assertEquals("The result should be 1", 1, result);
            }
        } catch (SQLException e) {
            fail("An unexpected SQL exception occurred: " + e.getMessage());
        }
    }
    @Test
    public void testConnectWithSchemaName() {
        // Set up the test data
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Biggestfoot09";
        String schemaName = "users";

        // Create the test connection
        TestRepositoryConnection connection = new TestRepositoryConnection(url, username, password);

        // Call the connect method with the schema name
        connection.connect(schemaName);

        // Verify the connection is not null
        Connection jdbcConnection = connection.getConnection();
        assertNotNull("The JDBC connection should not be null", jdbcConnection);

        try {
            // Perform a simple query to verify the connection
            try (Statement statement = jdbcConnection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT 1")) {

                // Verify the query result
                assertTrue("The result set should have at least one row", resultSet.next());
                int result = resultSet.getInt(1);
                assertEquals("The result should be 1", 1, result);
            }
        } catch (SQLException e) {
            fail("An unexpected SQL exception occurred: " + e.getMessage());
        }

        // Verify the schema name is set correctly
        assertEquals("The schema name should be set correctly", schemaName, connection.getSchemaName());
    }


    @Test
    public void testDisconnect() {
        connection.connect();

        Connection jdbcConnection = connection.getConnection();
        assertNotNull(jdbcConnection);

        connection.disconnect();

        try {
            // Attempt to use the disconnected connection
            Statement statement = jdbcConnection.createStatement();

            // If the connection is closed, an exception will be thrown
            assertEquals(false, statement.execute("SELECT 1"));

            // Clean up resources
            statement.close();
        } catch (SQLException e) {
            // Verify the expected exception message
            assertEquals("No operations allowed after connection closed.", e.getMessage());
        }
    }



 */

}


