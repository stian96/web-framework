package no.hiof.webframework.repository;

import no.hiof.webframework.interfaces.EntityModelBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Scenario 4.2
/**
 * Class for creating an entity model and adding to a database
 */
public class EntityModel implements EntityModelBuilder {
    private final RepositoryConnection repo;
    private String tableName;
    private final List<Field> fields = new ArrayList<>();

    /**
     * Constructs a new EntityModel object with the specified RepositoryConnection.
     *
     * @param repo the RepositoryConnection to be used by the EntityModel
     */
    public EntityModel(RepositoryConnection repo){
        this.repo = repo;
    }


    /**
     * Method for setting the table name in the schema
     * @param tableName the name of the table for the entity model
     * @return an instance of EntityModelBuilder with updated table name
     */



    @Override
    public EntityModelBuilder setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    /**

    * Overrides the superclass method to add a new field to the entity model builder.
    * @param name the name of the field
    * @param type the data type of the field
    * @param nullable indicates if the field can be null
    */

    @Override
    public EntityModelBuilder addField(String name, String type, boolean nullable) {
        fields.add(new Field(name,type,nullable));
        return this;


    }

    /**
     * Method for building a new EntityModel
     * @return instance of EntityModel
     */
    @Override
    public EntityModel build() {
        return this;
    }

    /**
     * Generates a new schema with the specified name and creates a table within the schema.
     *
     * @param schemaName the name of the schema to generate
     */
    public void generateSchema(String schemaName) {
        try {
            Connection connection = repo.createConnection(schemaName);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + schemaName);
            statement.executeUpdate("USE " + schemaName);
            String sql = generateCreateTableStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("Table " + tableName + " created successfully in schema " + schemaName);
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    /**
     * Retrieves the name of the table associated with this EntityModel.
     *
     * @return the name of the table
     */
    public String getTableName() {
        return tableName;
    }
    /**
     * Retrieves the list of fields associated with this EntityModel.
     *
     * @return the list of fields
     */
    public List<Field> getFields() {
        return fields;
    }

    /**

     * This method generates a SQL statement for creating a new database table with the fields and properties defined in
     * the fields list. The generated SQL statement includes the table name, field names, field types, and nullability
     * constraints.
     * @return a string containing the SQL statement for creating the table
     */
    private String generateCreateTableStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + tableName + " (");
        for (Field field : fields) {
            sb.append(field.getName() + " " + field.getType());
            if (field.isNullable()) {
                sb.append(" NULL,");
            } else {
                sb.append(" NOT NULL,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(");");
        return sb.toString();

    }

    /**
     * Represents a field in an EntityModel.
     */
    public static class Field {
        private final String name;
        private final String type;
        private final boolean nullable;

        /**
         * Constructs a new Field object with the specified name, type, and nullability.
         *
         * @param name     the name of the field
         * @param type     the data type of the field
         * @param nullable indicates if the field can be null
         */
        public Field(String name, String type, boolean nullable) {
            this.name = name;
            this.type = type;
            this.nullable = nullable;
        }

        /**
         * Retrieves the name of the field.
         *
         * @return the name of the field
         */
        protected String getName() {
            return name;
        }

        /**
         * Retrieves the data type of the field.
         *
         * @return the data type of the field
         */
        protected String getType() {
            return type;
        }

        /**
         * Checks if the field can be null.
         *
         * @return true if the field can be null, false otherwise
         */
        protected boolean isNullable() {
            return nullable;
        }
    }

}

