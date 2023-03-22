package no.hiof.webframework.Repository;


/**
 * Class for adding entity fields(columns)
 * to the database
 */
//TODO: Move to the EntityModel class to allow for better control
public class Field {

    private final String name;
    private final String type;
    private final boolean nullable;

    public Field(String name, String type, boolean nullable) {
        this.name = name;
        this.type = type;
        this.nullable = nullable;
    }
}


