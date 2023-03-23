package no.hiof.webframework.Interface;

import no.hiof.webframework.Data.User;

/**
 * This is an interface for a data access object (DAO) that provides
 * methods for saving, retrieving, and deleting user objects.
 */
public interface UserDAO {
    /**
     * Saves the given user object to the data store.
     * @param user The user object to save.
     */
    void save(User user);

    /**
     * Retrieves a user object with the given username from the data store.
     * @param username The username of the user to retrieve.
     * @return The user object with the given username, or null if no such user exists.
     */
    User get(String username);

    /**
     * Deletes the user object with the given username from the data store.
     * @param username The username of the user to delete.
     */
    void delete(String username);

}
