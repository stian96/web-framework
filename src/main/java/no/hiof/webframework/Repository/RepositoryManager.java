package no.hiof.webframework.Repository;

//Scenarios 4.4 and 4.6 can be made using this
import java.sql.*;

/**
 * Class for creating sql queries easily.
 */
public class RepositoryManager {
    private RepositoryConnection repo;

    public RepositoryManager(){
        repo = RepositoryConnection.create();
    }

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

    private String generateDeleteStatement(String tableName, String columnName) {
        return "DELETE FROM " + tableName + " WHERE " + columnName + " = ?";
    }
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

    public int getCountOfItemInDatabase(String tableName, String columnName, String item) {
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


    public void executeSqlQuery(String sqlQuery, String[] columnNames) {
        try {
            Connection connection = repo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Print the result
            System.out.println("SQL Query: " + sqlQuery);
            while (resultSet.next()) {
                // Retrieve and print the data from the result set based on column names
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
