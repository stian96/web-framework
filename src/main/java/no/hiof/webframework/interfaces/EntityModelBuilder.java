package no.hiof.webframework.interfaces;

import no.hiof.webframework.Repository.EntityModel;

/**

 * This interface defines a builder for creating an EntityModel.
 */
public interface EntityModelBuilder {
    /**

     * Sets the table name for the entity model.
     * @param tableName the name of the table for the entity model
     * @return the entity model builder with the updated table name
     */
    EntityModelBuilder setTableName(String tableName);
    /**

     * Adds a new field to the entity model.
     * @param name the name of the field
     * @param type the data type of the field
     * @param nullable indicates if the field can be null
     * @return the entity model builder with the new field added

     */
    EntityModelBuilder addField(String name, String type, boolean nullable);
    /**

     * Builds the entity model based on the previously added fields and table name.
     * @return the built entity model
     */

    EntityModel build();

}
