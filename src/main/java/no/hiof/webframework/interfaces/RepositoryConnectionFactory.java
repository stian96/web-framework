package no.hiof.webframework.interfaces;

import no.hiof.webframework.repository.RepositoryConnection;

public interface RepositoryConnectionFactory {
    RepositoryConnection createConnection();
}
