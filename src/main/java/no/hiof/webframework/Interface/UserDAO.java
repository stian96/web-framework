package no.hiof.webframework.Interface;

import no.hiof.webframework.Data.User;

public interface UserDAO {
    void save(User user);
    User get(String username);
    void delete(String username);

}
