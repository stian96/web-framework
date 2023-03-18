package no.hiof.webframework.Repository;

import no.hiof.webframework.Interface.RepositoryConnection;

public class SqlConnection implements RepositoryConnection {
    private String url;
    private String username;
    private String password;

/**
 *  Constructs a new SqlConnection object with the given URL, username, and password parameters.
 *  @param url The URL of the SQL database.
 *  @param username The username for accessing the SQL database.
 *  @param password The password for accessing the SQL database.
 */
    public SqlConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }


    @Override
    public void connect() {
        //TODO
    }

    @Override
    public void disconnect() {
        //TODO
    }
}
