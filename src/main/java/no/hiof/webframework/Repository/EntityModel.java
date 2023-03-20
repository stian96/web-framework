package no.hiof.webframework.Repository;

import no.hiof.webframework.Interface.EntityModelBuilder;

import java.util.ArrayList;
import java.util.List;

//Scenario 4.2
/**
 * Class for creating an entity model and adding to a database
 */
public class EntityModel implements EntityModelBuilder {
    private final String tableName;
    private List<String> fields = new ArrayList<>();



    public EntityModel(String tableName, List<String> fields) {
        this.tableName = tableName;
        this.fields = fields;
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
