package interfaces;

/**
 * Created by PetyoPetrov on 02.08.2016 г..
 */
public interface UserRepository{
    void addUser(User user);
    void updateUser(User user);
    User findUserByUsername(String username);
    Iterable<User> getAllUsers();
    void load();

}
