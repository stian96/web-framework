package no.hiof.webframework.Repository;

import no.hiof.webframework.Interface.EntityModelBuilder;

public class EntityModel implements EntityModelBuilder {

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
