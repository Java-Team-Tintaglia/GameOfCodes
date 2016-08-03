package interfaces;
/*
* <summary>
* 	This interface defines the behaviour for the User.
* </summary>
* */

public interface UserRepository{
    /*
* <summary>
*     This method is used to add User.
* </summary>
* <parameters>
* 	<param type='User'>user</param>
* </parameters>
* */
    void addUser(User user);
    /*
* <summary>
*     This method is used to update User.
* </summary>
* <parameters>
* 	<param type='User'>user</param>
* </parameters>
* */
    void updateUser(User user);
    /*
    * <summary>
    *     A method
    * </summary>
    * <returns>
    * 	Returns String indicating the user by name.
    * </returns>
    * */
    User findUserByUsername(String username);
    Iterable<User> getAllUsers();
    /*
* <summary>
*     This method loads the user.
* </summary>
* */
    void load();

}
