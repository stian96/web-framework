package no.hiof.webframework.repository;

//Scenarios 4.4 and 4.6 can be made using this
import java.sql.*;

/**
 * Class used to manage repositories. It allows access and manipulation of
 * data in a database.
 */
public class RepositoryManager {
    private RepositoryConnection repo;

    public RepositoryManager(RepositoryConnection repo){
        this.repo = repo;
    }

    /**

     * Inserts a new row into the specified table with the given column names and values.
     * @param tableName the name of the table to insert the row into
     * @param columnNames an array of strings containing the column names of the table
     * @param values an array of objects containing the values to insert into the row
     * @return true if the row was inserted successfully, false otherwise
     * @throws SQLException if an error occurs while inserting the row
     */
    public boolean insert(String tableName, String[] columnNames, Object[] values) {
        try {

            Connection connection = repo.getConnection();
            String sql = generateInsertStatement(tableName, columnNames);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            for (int i = 0; i < columnNames.length; i++) {
                preparedStatement.setObject(i + 1, values[i]);
            }


            int result = preparedStatement.executeUpdate();


            if (result > 0) {
                System.out.println("Row inserted successfully!");
                return true;
            } else {
                System.out.println("Failed to insert row.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error inserting row: " + e.getMessage());
            return false;
        }
    }
    /**

     * Generates an SQL INSERT statement for a given table name and array of column names.
     * @param tableName the name of the table to insert the values into
     * @param columnNames the names of the columns to insert values into
     * @return a string containing the generated INSERT statement
     */
    private String generateInsertStatement(String tableName, String[] columnNames) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(tableName).append(" (");

        for (int i = 0; i < columnNames.length; i++) {
            sb.append(columnNames[i]);
            if (i < columnNames.length - 1) {
                sb.append(", ");
            }
        }

        sb.append(") VALUES (");


        for (int i = 0; i < columnNames.length; i++) {
            sb.append("?");
            if (i < columnNames.length - 1) {
                sb.append(", ");
            }
        }

        sb.append(")");

        return sb.toString();
    }
    /**

    * Deletes a row from a table with a given table name, column name and value.
    *
    * @param tableName the name of the table
    * @param columnName the name of the column to be used as a condition in the WHERE clause of the DELETE statement
    * @param value the value of the column to be used as a condition in the WHERE clause of the DELETE statement
    * @return true if the row was successfully deleted, false otherwise
    */
    public boolean delete( String tableName, String columnName, Object value) {
        try {
            Connection connection = repo.getConnection();
            String sql = generateDeleteStatement(tableName, columnName);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, value);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Row deleted successfully!");
                return true;
            } else {
                System.out.println("Failed to delete row.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error deleting row: " + e.getMessage());
            return false;
        }
    }
    /**

    * Generates a SQL delete statement for the specified table and column.
    * @param tableName the name of the table to delete from
    * @param columnName the name of the column to use in the WHERE clause
    * @return a String containing the SQL delete statement
     */
    private String generateDeleteStatement(String tableName, String columnName) {
        return "DELETE FROM " + tableName + " WHERE " + columnName + " = ?";
    }
    /**

     * This method retrieves all rows from the specified table and prints them to the console.
     * @param tableName The name of the table to retrieve rows from.
     */
    public void getAllRowsFromTable(String tableName) {
        try {
            Connection connection = repo.getConnection();
            String sql = "SELECT * FROM " + tableName;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print the result
            System.out.println("Table: " + tableName + " - All Rows:");
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(i);
                    System.out.println(columnName + ": " + columnValue);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving rows from table: " + e.getMessage());
        }
    }
    /**
     * Retrieves rows from a specified table with a specified condition on a specified column
     *
     * @param tableName The name of the table to retrieve rows from
     * @param columnName The name of the column to use as condition
     * @param condition The condition to filter the rows by
     */

    public void getRowsFromTableWithConditions(String tableName, String columnName, String condition) {
        try {
            Connection connection = repo.getConnection();
            String sql = "SELECT * FROM " + tableName + " WHERE " + columnName + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, condition);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Table: " + tableName + " - Rows with Condition: " + columnName + " = " + condition);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnNameResult = resultSetMetaData.getColumnName(i);
                    String columnValue = resultSet.getString(i);
                    System.out.println(columnNameResult + ": " + columnValue);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving rows from table: " + e.getMessage());
        }
    }

    /**
     * Counts the number of occurrences of a specific item in a column of a table in the database.
     *
     * @param tableName the name of the table to search
     * @param columnName the name of the column to search
     * @param item the item to count
     * @return the number of occurrences of the item in the column
     */

    public int itemCount(String tableName, String columnName, String item) {
        int count = 0;
        try {
            Connection connection = repo.getConnection();
            String sql = "SELECT COUNT(*) AS count FROM " + tableName + " WHERE " + columnName + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, item);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

            System.out.println("Item: " + item + " is in the Table: " + tableName + " "  + count + " time(s)");
        } catch (SQLException e) {
            System.err.println("Error retrieving count from database: " + e.getMessage());
        }
        return count;
    }

    /**
     * Executes an SQL query and prints the results to the console.
     *
     * @param sqlQuery the SQL query to execute
     * @param columnNames an array of column names to print in the results
     */
    public void executeSqlQuery(String sqlQuery, String[] columnNames) {
        try {
            Connection connection = repo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            ResultSet resultSet = preparedStatement.executeQuery();


            System.out.println("SQL Query: " + sqlQuery);
            while (resultSet.next()) {

                for (String columnName : columnNames) {
                    String columnValue = resultSet.getString(columnName);
                    System.out.println(columnName + ": " + columnValue);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }




}
