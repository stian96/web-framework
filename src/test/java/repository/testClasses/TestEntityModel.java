package repository.testClasses;

import no.hiof.webframework.interfaces.EntityModelBuilder;
import no.hiof.webframework.repository.EntityModel;
import no.hiof.webframework.repository.RepositoryConnection;

import java.util.List;

import no.hiof.webframework.repository.EntityModel;

import java.util.List;

public class TestEntityModel extends EntityModel implements EntityModelBuilder {
    public TestEntityModel(RepositoryConnection repo) {
        super(repo);
    }

    @Override
    public String getTableName() {
        return super.getTableName();
    }

    @Override
    public List<Field> getFields() {
        return super.getFields();
    }

    @Override
    public EntityModelBuilder setTableName(String tableName) {
        super.setTableName(tableName);
        return this;
    }

    @Override
    public EntityModelBuilder addField(String name, String type, boolean nullable) {
        super.addField(name, type, nullable);
        return this;
    }

    @Override
    public EntityModel build() {
        return super.build();
    }



}
