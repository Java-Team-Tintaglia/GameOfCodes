package interfaces;

/**
 * This interface defines the behavior for a User Repository.
 */
public interface UserRepository {
	
    /**
     * This method is used to add a User.
     * @param user - the user that will be added.
     */
    void addUser(User user);

    /**
     * This method is used to update a User.
     * @param user - the user that will be updated.
     */
    void updateUser(User user);

    /**
     * A method that is used to find users by username.
     * @param username.
     * @return the found user by username.
     */
    User findUserByUsername(String username);

    /**
     *  This method loads all users.
     */
    void load();

}
