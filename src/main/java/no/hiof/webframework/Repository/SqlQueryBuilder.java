package no.hiof.webframework.Repository;

//Scenarios 4.4 - 4.6 can be made using this
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for creating sql queries easily.
 */
public class SqlQueryBuilder {

    private String tableName;
    private List<String> columns = new ArrayList<>();
    private List<String> conditions = new ArrayList<>();

    /**
     * Method for adding a specified column to the list of columns
     * @param columns
     * @return instance of SqlQueryBuilder
     */
    public SqlQueryBuilder select(String columns) {
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }

    /**
     * Method for setting the table name in an SQL query
     * @param tableName
     * @return instance of SqlQueryBuilder
     */

    public SqlQueryBuilder from(String tableName) {
        this.tableName = tableName;
        return this;
    }

    /**
     * Method that adds condition to the SQL query
     *
     * @param condition
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
    public PreparedStatement build(Connection conn) throws SQLException {
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
        return conn.prepareStatement(sb.toString());

    }
}
