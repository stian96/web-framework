package no.hiof.webframework.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * For now this is brainstorming. change to interface??
 * Builder class for creating entities to add to a repository
 *
 */
public class EntityBuilder {
    private final String tableName;
    private final List<String> columns;

    public EntityBuilder(String tableName, List<String> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    /**
     * method for setting the table name in progress
     * @param tableName
     * @return
     */
    public EntityBuilder setTableName(String tableName) {

        return this;
    }

    /**
     * method for adding columns
     * @param column
     * @return
     */
    public EntityBuilder addColumn(String column) {

        return this;
    }

    /**
     * method for building the model
     */


}
