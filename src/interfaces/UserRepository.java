package interfaces;

/**
 * This interface defines the behaviour for the User.
 */

public interface UserRepository{
    /**
     * This method is used to add User.
     * @param user the user that will be added.
     */
    void addUser(User user);

    /**
     * This method is used to update User.
     * @param user the user that will be updated.
     */
    void updateUser(User user);

    /**
     * A method that is used to find users by name.
     * @param username the found user by name.
     * @return the found user by name.
     */

    User findUserByUsername(String username);

    /**
     * A method that gets all users.
     * @return all users.
     */
    Iterable<User> getAllUsers();

    /**
     *  This method loads the user.
     */
    void load();

}
