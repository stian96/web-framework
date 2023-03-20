package no.hiof.webframework.Repository;

import no.hiof.webframework.Interface.EntityModelBuilder;

//Scenario 4.2
/**
 * Class for creating an entity model and adding to a database
 */
public class EntityModel implements EntityModelBuilder {
    private final String tableName;


    public EntityModel(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public EntityModelBuilder setTableName(String tableName) {
        return null;
    }

    @Override
    public EntityModelBuilder addField(String name, String type, boolean nullable) {
        return null;
    }

    @Override
    public EntityModel build() {
        return null;
    }
}
