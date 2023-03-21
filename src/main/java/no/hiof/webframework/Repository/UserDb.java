package no.hiof.webframework.Repository;

import no.hiof.webframework.Data.User;
import no.hiof.webframework.Interface.UserDAO;

public class UserDb implements UserDAO {

    // TODO: Connect to database.

    @Override
    public void save(User user) {
        // TODO: save user to database.
    }

    @Override
    public User get(String username) {
        // TODO: return user from database.
        return null;
    }

    @Override
    public void delete(String username) {
        // TODO: delete user from database.
    }
}
