package interfaces;

/*
* <summary>
* 	This interface defines the behaviour for the User Functionality.
* </summary>
* */
public interface AuthenticationProvider {

	/*
	* <summary>
	*     This method is used to authenticate the user upon logout attempt
	* </summary>
	* <parameters>
	* 	<param type='String'>username</param>
	* 	<param type='String'>password</param>
	* </parameters>
	* */
	void authenticate(String username, String password);
	void logout();

	/*
	* <summary>
	*     A method used to get the currently Logged in user.
	* </summary>
	* <returns>
	* 	The currently logged in user
	* </returns>
	* */
	User getLoggedUser();
}
