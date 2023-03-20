package no.hiof.webframework.Repository;

//Scenarios 4.4 - 4.6
import java.sql.Connection;
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
     * adds specified columns to the SELECT statement of the query
     * @param tableName
     * @return instance of SqlStringBuilder
     */
    public SqlQueryBuilder select(String tableName){
        //TODO
        return this;
    }

    /**
     * Method for specifying the selected columns
     * @param columns
     * @return SqlQueryBuilder instance
     */
    public SqlQueryBuilder from(String columns){
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }

    /**
     * Method for the where part of the
     * @param condition
     * @return SqlQueryBuilder instance
     */

    public SqlQueryBuilder where(String condition){
        this.conditions.add(condition);
        return this;
    }

    /**
     * method to build the string
     * @param conn
     */
    public void build(Connection conn){
        //Todo
    }

}
