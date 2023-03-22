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


/*
    public EntityModel(String tableName, List<Field> fields) {
        this.tableName = tableName;

    }


 */

    /**
     * Method for setting the table name in the schema
     * @param tableName
     * @return an instance of EntityModelBuilder
     */

    @Override
    public EntityModelBuilder setTableName(String tableName) {

        return this;
    }

    /**
     * Method that adds a new field to the entity
     * @param name of column
     * @param type datatype of the column
     * @param nullable
     * @return EntityModelBuilder instance
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

}
