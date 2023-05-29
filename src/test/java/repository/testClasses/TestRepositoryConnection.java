package repository.testClasses;

import no.hiof.webframework.repository.RepositoryConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestRepositoryConnection extends RepositoryConnection {

    public TestRepositoryConnection(String url, String username, String password) {
        super(url, username, password);
    }

    @Override
    protected Connection createConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected Connection createConnection(String schemaName) {
        try {
            String newUrl = url + schemaName;
            return DriverManager.getConnection(newUrl,username, password);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }


    @Override
    public Connection getConnection() {

        return super.getConnection();
    }

    @Override
    public String getUrl(){
        return super.getUrl();
    }

    @Override
    public String getSchemaName(){return super.getSchemaName();}
}