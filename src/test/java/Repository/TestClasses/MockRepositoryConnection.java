package Repository.TestClasses;

import no.hiof.webframework.repository.RepositoryConnection;

public class MockRepositoryConnection extends RepositoryConnection {

    private boolean isConnectMethodCalled = false;
    private boolean isDisconnectMethodCalled = false;
    private boolean isConnectWithSchemaMethodCalled = false;

    // Override the connect() method
    @Override
    public void connect() {
        isConnectMethodCalled = true;
    }

    // Override the connect(String schemaName) method
    @Override
    public void connect(String schemaName) {
        isConnectWithSchemaMethodCalled = true;
    }

    // Override the disconnect() method
    @Override
    public void disconnect() {
        isDisconnectMethodCalled = true;
    }


    // Add getters to check if the methods are called
    public boolean isConnectMethodCalled() {
        return isConnectMethodCalled;
    }

    public boolean isConnectWithSchemaMethodCalled() {
        return isConnectWithSchemaMethodCalled;
    }

    public boolean isDisconnectMethodCalled() {
        return isDisconnectMethodCalled;
    }
}
