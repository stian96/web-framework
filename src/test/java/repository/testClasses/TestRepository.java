package repository.testClasses;

import no.hiof.webframework.repository.RepositoryConnection;

public class TestRepository extends RepositoryConnection {
    @Override
    public String getPassword() {
        return super.getPassword();
    }
    @Override
    public String getUsername(){
        return super.getUsername();
    }
    @Override
    public String getUrl(){
        return super.getUrl();
    }
    @Override
    public String getSchemaName(){
        return  super.getSchemaName();
    }


}