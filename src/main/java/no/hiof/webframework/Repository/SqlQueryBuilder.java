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


    public SqlQueryBuilder select(String columns) {
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }


    public SqlQueryBuilder from(String tableName) {
        this.tableName = tableName;
        return this;
    }

    /**
     * Method for the where part of the
     *
     * @param condition
     * @return SqlQueryBuilder instance
     */

    public SqlQueryBuilder where(String condition) {
        this.conditions.add(condition);
        return this;
    }

    /**
     * method to build the string
     *
     * @param conn
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
