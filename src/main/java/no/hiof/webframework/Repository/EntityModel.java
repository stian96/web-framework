package no.hiof.webframework.Repository;

import no.hiof.webframework.Interface.EntityModelBuilder;

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
    private RepositoryConnection repo;
    private String tableName;
    private List<Field> fields = new ArrayList<>();
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

     * This method generates a new database schema with the specified name, creates a table in the schema using the
     * generateCreateTableStatement() method, and outputs a message to the console indicating that the table has been
     * successfully created in the schema.
     * @param schemaName the name of the new database schema to be created
     * @throws SQLException if an error occurs while executing SQL statements
     */
    public void generateSchema(String schemaName) {
        try {
            Connection connection = repo.getConnection();
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

    public static class Field {


        private final String name;
        private final String type;
        private final boolean nullable;

        /**
         * Constructs a new Field object
         * @param name name the name of the field
         * @param type type the data type of the field
         * @param nullable nullable indicates if the field can be null
         */
        public Field(String name, String type, boolean nullable) {
            this.name = name;
            this.type = type;
            this.nullable = nullable;
        }
        public String getName() {
            return name;
        }

        protected String getType() {
            return type;
        }

        protected boolean isNullable() {
            return nullable;
        }

    }

}
