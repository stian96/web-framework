package repository;

import no.hiof.webframework.repository.RepositoryManager;
import org.junit.Before;
import org.junit.Test;
import repository.testClasses.TestRepositoryConnection;

import static org.junit.Assert.*;

public class RepositoryManagerTest {
    /**
     * The tests for the Repository are done but are runnable if a test db is set up. Due to time constraints we could not include
     * a test db into the project
     */
    /*
    private RepositoryManager repositoryManager;

    @Before
    public void setUp() {

        TestRepositoryConnection mockConnection = new TestRepositoryConnection("jdbc:mysql://localhost:3306/", "root", "password");
        mockConnection.connect("users");
        repositoryManager = new RepositoryManager(mockConnection);
    }

    @Test
    public void testInsert() {
        String tableName = "users";
        String[] columnNames = {"id","user_name", "password"};
        Object[] values = {1,"ugh", "John"};

        boolean result = repositoryManager.insert(tableName, columnNames, values);

        assertTrue(result);
    }

    @Test
    public void testDelete() {
        String tableName = "users";
        String columnName = "id";
        Object value = 1;

        boolean result = repositoryManager.delete(tableName, columnName, value);

        assertTrue(result);
    }

    @Test
    public void testGetAllRowsFromTable() {
        String tableName = "users";

        // Verifies method runs without exceptions
        repositoryManager.getAllRowsFromTable(tableName);
    }

    @Test
    public void testGetRowsFromTableWithConditions() {
        String tableName = "users";
        String columnName = "id";
        String condition = "1";

        // Verifies method runs without exceptions
        repositoryManager.getRowsFromTableWithConditions(tableName, columnName, condition);
    }

    @Test
    public void testItemCount() {
        String tableName = "users";
        String columnName = "user_name";
        String item = "ugh";

        int count = repositoryManager.itemCount(tableName, columnName, item);

        assertEquals(1, count);
    }

    @Test
    public void testExecuteSqlQuery() {
        String sqlQuery = "SELECT * FROM users";
        String[] columnNames = {"id", "user_name"};

        //Verifies that the method executes without returning an exception
        repositoryManager.executeSqlQuery(sqlQuery, columnNames);
    }


     */

}
