package interfaces;

public interface UserRepository{
    void addUser(User user);
    void updateUser(User user);
    User findUserByUsername(String username);
    Iterable<User> getAllUsers();
    void load();

}
