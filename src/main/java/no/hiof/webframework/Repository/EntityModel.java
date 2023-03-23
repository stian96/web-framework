package no.hiof.webframework.Repository;

import no.hiof.webframework.Interface.EntityModelBuilder;

import java.util.ArrayList;
import java.util.List;

//Scenario 4.2
/**
 * Class for creating an entity model and adding to a database
 */
public class EntityModel implements EntityModelBuilder {
    private String tableName;
    private List<Field> fields = new ArrayList<>();


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
     * Method for generating schema
     */
    public void generateSchema(){
        //TODO
    }

    /**
     * The Field class represents a field in an entity model, consisting of a name, data type, and nullability.
     */
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
    }

}
