package no.hiof.webframework.repository;

import no.hiof.webframework.exceptions.ConnectionCreationException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RepositoryConnectionHandler extends RepositoryConnection {


    public RepositoryConnectionHandler(String url, String username, String password) {
        super(url, username, password);

    }

    @Override
    protected Connection createConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Error creating database connection: " + e.getMessage());
            throw new ConnectionCreationException("Failed to create database connection.", e);
        }
    }
    @Override
    protected Connection createConnection(String schemaName) {
        try {
            String urlWithSchema = url  + schemaName;
            return DriverManager.getConnection(urlWithSchema, username, password);
        } catch (SQLException e) {
            System.err.println("Error creating database connection: " + e.getMessage());
            throw new ConnectionCreationException("Failed to create database connection.", e);
        }
    }
}
