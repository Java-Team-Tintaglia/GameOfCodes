package interfaces;

/**
 * Created by PetyoPetrov on 02.08.2016 г..
 */
public interface UserRepository<T> {
    void addUser(T user);
    void updateUser(T user);
    User findUserByUsername(String username);
    Iterable<User> getAllUsers();
    void load();

}
