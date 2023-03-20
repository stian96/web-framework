package no.hiof.webframework.Interface;

import no.hiof.webframework.Repository.EntityModel;

/**
 * Still trying out ideas
 */
public interface EntityModelBuilder {

    /**
     * Method that sets the table name takes
     * @param tableName
     * @return table
     */
    EntityModelBuilder setTableName(String tableName);

    /**
     * Method that takes the following parameters
     * @param name
     * @param type
     * @param nullable
     * @return //TODO
     */
    EntityModelBuilder addField(String name, String type, boolean nullable);

    /**
     * Method that uses the above methods to return
     * @return EntityModel
     */
    EntityModel build();
    /**
     * Not sure about the above class or method
     * //TODO
     */
}
