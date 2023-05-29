package repository;

import no.hiof.webframework.interfaces.EntityModelBuilder;
import no.hiof.webframework.repository.EntityModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.testClasses.TestField;
import repository.testClasses.TestRepositoryConnection;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class EntityModelTest {
    /*
    private TestRepositoryConnection repoConnection;
    private EntityModel entityModel;

    @BeforeEach
    public void setUp() {
        repoConnection = new TestRepositoryConnection("jdbc:mysql://localhost:3306/", "root", "password");
        entityModel = new EntityModel(repoConnection);
    }

    @Test
    public void testSetTableName() {
        String tableName = "myTable";
        EntityModelBuilder modelBuilder = entityModel.setTableName(tableName);

        Assertions.assertEquals(tableName, entityModel.getTableName());
        Assertions.assertEquals(entityModel, modelBuilder);
    }

    @Test
    public void testAddField() {
        String fieldName = "myField";
        String fieldType = "VARCHAR";
        boolean nullable = true;

        EntityModelBuilder modelBuilder = entityModel.addField(fieldName, fieldType, nullable);

        List<EntityModel.Field> fields = entityModel.getFields();
        Assertions.assertEquals(1, fields.size());
        EntityModel.Field field = fields.get(0);

        // Access the protected 'name', 'type', and 'nullable' fields using reflection
        String name = null;
        String type = null;
        boolean isNullable = false;
        try {
            Field nameField = EntityModel.Field.class.getDeclaredField("name");
            Field typeField = EntityModel.Field.class.getDeclaredField("type");
            Field nullableField = EntityModel.Field.class.getDeclaredField("nullable");
            nameField.setAccessible(true);
            typeField.setAccessible(true);
            nullableField.setAccessible(true);
            name = (String) nameField.get(field);
            type = (String) typeField.get(field);
            isNullable = nullableField.getBoolean(field);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Verify the field properties
        Assertions.assertEquals(fieldName, name);
        Assertions.assertEquals(fieldType, type);
        Assertions.assertEquals(nullable, isNullable);
        Assertions.assertEquals(entityModel, modelBuilder);
    }

    @Test
    public void testBuild() {
        EntityModel builtModel = entityModel.build();

        Assertions.assertEquals(entityModel, builtModel);
    }
/*
    @Test
    public void testGenerateSchema() {
        String schemaName = "mySchema";
        String tableName = "myTable";

        try {
            // Invoke the method under test
            entityModel.generateSchema(schemaName);



            // Verify if the table is actually created in the schema

            Statement statement = repoConnection.createStatement();
            ResultSet resultSet = statement.executeQuery("SHOW TABLES IN " + schemaName);
            boolean tableExists = false;
            while (resultSet.next()) {
                if (resultSet.getString(1).equalsIgnoreCase(tableName)) {
                    tableExists = true;
                    break;
                }
            }
            Assertions.assertTrue(tableExists);

        } catch (SQLException e) {
            Assertions.fail("Exception occurred: " + e.getMessage());
        }
    }



 */
}