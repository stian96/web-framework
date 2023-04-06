package no.hiof.webframework.Repository;

//Scenarios 4.4 and 4.6 can be made using this
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Class for creating sql queries easily.
 */
public class SqlQueryBuilder {

    public boolean insert(RepositoryConnection repo,String tableName, String[] columnNames, Object[] values) {
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
    public boolean delete(RepositoryConnection repo, String tableName, String columnName, Object value) {
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
    public void getAllRowsFromTable(RepositoryConnection repo, String tableName) {
        try {
            Connection connection = repo.getConnection();
            String sql = "SELECT * FROM " + tableName;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Print the result
            System.out.println("Table: " + tableName + " - All Rows:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                // ... get other columns as needed
                System.out.println("ID: " + id + ", Username: " + username + ", Email: " + password);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving rows from table: " + e.getMessage());
        }
    }



}
