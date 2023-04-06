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




}
