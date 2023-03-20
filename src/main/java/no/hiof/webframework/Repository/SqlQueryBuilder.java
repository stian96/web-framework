package no.hiof.webframework.Repository;

import java.util.ArrayList;
import java.util.Collections;
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
     * @return
     */
    public SqlQueryBuilder from(String columns){
        //TODO
        return this;
    }



}
