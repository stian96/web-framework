package no.hiof.webframework.Repository;

import no.hiof.webframework.data.User;
import no.hiof.webframework.Interface.UserDAO;

import java.util.ArrayList;

/**
 * The UserDb class implements the UserDAO interface and provides methods to save,
 * get and delete user objects from the temporary database.
 */
public class UserDb implements UserDAO {

    // Temporary database storage.
    private final ArrayList<User> db = new ArrayList<>();

    /**
     * Saves a user object to the database.
     * @param user The user object to be saved.
     */
    @Override
    public void save(User user) {
        db.add(user);
    }

    /**
     * Retrieves a user object from the database based on the username.
     * @param username The username of the user to retrieve.
     * @return The user object with the given username, or null if it does not exist in the database.
     */
    @Override
    public User get(String username) {
        for (User user : db) {
            if (user.username().equals(username))
                return user;
        }
        return null;
    }

    /**
     * Deletes a user object from the database based on the username.
     * @param username The username of the user to delete.
     */
    @Override
    public void delete(String username) {
        db.removeIf(user -> user.username().equals(username));
    }

    /**
     * Returns the entire ArrayList of users in the database.
     * @return The ArrayList of users in the database.
     */
    public ArrayList<User> getDb() {
        return db;
    }
}
