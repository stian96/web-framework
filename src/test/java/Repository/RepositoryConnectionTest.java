package Repository;

import Repository.TestClasses.MockRepositoryConnection;
import Repository.TestClasses.TestRepository;
import no.hiof.webframework.repository.RepositoryConnection;

import org.junit.Test;
import static org.junit.Assert.*;

public class RepositoryConnectionTest {

    @Test
    public void testCreateSingletonInstance() {
        RepositoryConnection connection1 = RepositoryConnection.create();
        RepositoryConnection connection2 = RepositoryConnection.create();
        assertSame("Two instances of RepositoryConnection should be the same.", connection1, connection2);
    }

    @Test
    public void testAddRepositoryDetails() {
        TestRepository connection = new TestRepository();
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "user";
        String password = "password";
        connection.addRepositoryDetails(url, username, password);
        assertEquals("URL should be set correctly.", url, connection.getUrl());
        assertEquals("Username should be set correctly.", username, connection.getUsername());
        assertEquals("Password should be set correctly.", password, connection.getPassword());
    }

    @Test
    public void testConnect() {
        MockRepositoryConnection connection = new MockRepositoryConnection();
        connection.connect();
        assertTrue("connect() method should be called.", connection.isConnectMethodCalled());
    }

    @Test
    public void testConnectWithSchemaName() {
        MockRepositoryConnection connection = new MockRepositoryConnection();
        TestRepository conn = new TestRepository();
        String schemaName = "test_schema";
        connection.connect(schemaName);

        assertTrue("connect(String schemaName) method should be called.", connection.isConnectWithSchemaMethodCalled());
        assertNotEquals("Schema name should be set correctly.", schemaName, conn.getSchemaName());
    }
    @Test
    public void testDisconnect() {
        MockRepositoryConnection connection = new MockRepositoryConnection();
        connection.disconnect();
        assertTrue("disconnect() method should be called.", connection.isDisconnectMethodCalled());
    }
    @Test
    public void testGetInstance() {
        RepositoryConnection connection = RepositoryConnection.create();
        assertSame("getInstance() should return the same instance as create().", connection, connection.getInstance());
    }



    @Test(expected = IllegalStateException.class)
    public void testGetConnectionWithoutConnecting() {
        RepositoryConnection connection = RepositoryConnection.create();
        connection.getConnection();
    }
}
