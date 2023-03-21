package no.hiof.webframework.Repository;

import no.hiof.webframework.Data.User;
import no.hiof.webframework.Interface.UserDAO;

import java.util.ArrayList;

public class UserDb implements UserDAO {

    // Temporary database storage.
    private final ArrayList<User> db = new ArrayList<>();

    // TODO: Connect to database.

    @Override
    public void save(User user) {
        db.add(user);
    }

    @Override
    public User get(String username) {
        for (User user : db) {
            if (user.username().equals(username))
                return user;
        }
        return null;
    }

    @Override
    public void delete(String username) {
        db.removeIf(user -> user.username().equals(username));
    }

    public ArrayList<User> getDb() {
        return db;
    }
}
