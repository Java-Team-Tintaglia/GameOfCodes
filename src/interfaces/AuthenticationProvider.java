package interfaces;

/**
 * This interface defines the behavior for the User Authentication Functionality.
 */
public interface AuthenticationProvider {

	/**
	*  This method is used to authenticate the user upon logout attempt.
	* @param username - the username that needs to be authenticated.
	* @param password - the password that needs to be authenticated.
	 */
	void authenticate(String username, String password);

	/**
	 * This method is used for user's logging out.
	 */
	void logout();

	/**
	*    A method used to get the currently Logged in user.
	* 	@return The currently logged in user.
	*/
	User getLoggedUser();
	
	/**
	 * This method sets the user repository
	 * @param userRepository
	 */
	void setUserRepository(UserRepository userRepository);
	
	/**
	 * This method sets the user repository
	 * @param userRepository
	 */
	UserRepository getUserRepository();
}
