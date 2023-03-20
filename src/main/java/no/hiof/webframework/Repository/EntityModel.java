package no.hiof.webframework.Repository;

import no.hiof.webframework.Interface.EntityModelBuilder;

//Scenario 4.2
/**
 * Class for creating an entity model and adding to a database
 */
public class EntityModel implements EntityModelBuilder {
    private final String tableName;
    private final Field field;


    public EntityModel(String tableName, Field field) {
        this.tableName = tableName;
        this.field = field;
    }

    @Override
    public EntityModelBuilder setTableName(String tableName) {
        return null;
    }

    @Override
    public EntityModelBuilder addField(String name, String type, boolean nullable) {
        return null;

        //Have to fix this. Doesn't make sense
        // TODO
    }

    @Override
    public EntityModel build() {
        return null;
    }

    /**
     * Method for generating schema
     */
    public void generateSchema(){
        //TODO
    }
}
