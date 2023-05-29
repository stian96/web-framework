package repository.testClasses;

import no.hiof.webframework.repository.EntityModel;

public class TestField extends EntityModel.Field {
    public TestField(String name, String type, boolean nullable) {
        super(name, type, nullable);
    }

    public String getName() {
        return super.getName();
    }

    public String getType() {
        return super.getType();
    }

    public boolean isNullable() {
        return super.isNullable();
    }
}
