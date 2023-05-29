package repository;

import no.hiof.webframework.repository.RepositoryConnection;
import no.hiof.webframework.repository.RepositoryConnectionHandler;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import repository.testClasses.TestRepositoryConnection;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class RepositoryConnectionHandlerTest {
    /*
    private RepositoryConnectionHandler connectionHandler;
    private TestRepositoryConnection repo;
    @BeforeEach
    void setUp() {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "password";
        repo = new TestRepositoryConnection(url,username,password);
    }

    @AfterEach
    void tearDown() {
        // Disconnect from the database after each test
        connectionHandler.disconnect();
    }

    @Test
    void testConnect() {
        // Act
        connectionHandler.connect();

        // Assert
        Connection connection = connectionHandler.getConnection();
        assertNotNull(connection);
        try {
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            fail("Failed to check connection status.");
        }
    }

    @Test
    void testConnectWithSchemaName() {
        // Arrange
        String schemaName = "mySchema";

        // Act
        connectionHandler.connect(schemaName);

        // Assert
        Connection connection = connectionHandler.getConnection();
        assertNotNull(connection);
        try {
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            fail("Failed to check connection status.");
        }
    }

    @Test
    void testDisconnect() {
        // Arrange
        connectionHandler.connect();

        // Act
        connectionHandler.disconnect();

        // Assert
        Connection connection = connectionHandler.getConnection();
        assertNull(connection);
    }
*/
}


