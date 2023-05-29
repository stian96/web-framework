package no.hiof.webframework.interfaces;

import no.hiof.webframework.repository.RepositoryConnection;

/**
 * The {@code RepositoryConnectionFactory} interface defines a contract for creating instances of {@link RepositoryConnection}.
 * It serves as a factory interface for producing {@link RepositoryConnection} objects.
 */
public interface RepositoryConnectionFactory {
    /**
     * Creates a new instance of {@link RepositoryConnection}.
     * @return a {@link RepositoryConnection} object
     *
     */
    RepositoryConnection createConnection();
}
