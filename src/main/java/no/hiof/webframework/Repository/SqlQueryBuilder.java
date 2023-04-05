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

    private String tableName;
    private final List<String> columns = new ArrayList<>();
    private final List<String> conditions = new ArrayList<>();


    /**
     * Method for adding a specified column to the list of columns
     * @param columns to be selected
     * @return instance of SqlQueryBuilder
     */
    public SqlQueryBuilder select(String columns) {
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }

    /**
     * Method for setting the table name in an SQL query
     * @param tableName the table where the selected columns are from
     * @return instance of SqlQueryBuilder
     */

    public SqlQueryBuilder from(String tableName) {
        this.tableName = tableName;
        return this;
    }

    /**
     * Method that adds condition to the SQL query
     *
     * @param condition the conditions by which to sort the query
     * @return SqlQueryBuilder instance
     */

    public SqlQueryBuilder where(String condition) {
        this.conditions.add(condition);
        return this;
    }

    /**
     * Builds an SQL query as a PreparedStatement object and returns it
     * @param conn a Connection object representing the database connection
     * @return PreparedStatement object
     * @throws SQLException if problem creating the object
     */
    public ResultSet build(Connection conn) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT");
        if (columns.isEmpty()) {
            sb.append("*");
        } else {
            sb.append(String.join(", ", columns));
        }
        sb.append(" FROM ").append(tableName);
        if (!conditions.isEmpty()) {
            sb.append(" WHERE ").append(String.join(" AND ", conditions));
        }
        PreparedStatement stmt = conn.prepareStatement(sb.toString());
        return stmt.executeQuery();

    }

    /**
     * Inserts data into a table in the database specified by the given table name and data.
     * The data is passed as a Map where the keys represent the column names and the values
     * represent the corresponding
     * values to be inserted in those columns.
     * @param tableName the name of the table where the data is to be inserted
     * @param data data a Map where the keys represent the column names and the values
     * represent the corresponding values to be inserted in those columns
     * @throws SQLException
     */
    public void insert(String tableName, Map<String, Object> data) throws SQLException {
        //TODO:implementation of this
    }


}
