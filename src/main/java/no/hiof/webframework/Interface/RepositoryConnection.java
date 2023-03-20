package no.hiof.webframework.Interface;

/**
 * An interface which provides methods
 * for connecting and disconnecting a repository.
 */
public interface RepositoryConnection {
    /**
     Establishes a connection to the repository.
     */
    void connect();
    /**
     Closes the connection to the repository.
     */
    void disconnect();
}
