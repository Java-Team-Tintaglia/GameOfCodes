package interfaces;

/**
 * This interface defines the behavior for a User.
 */
public interface User {
	
	/**
	 * A method that indicates the password of the user.
	 * @return String that indicates the password of the user.
	 */
	String getPassword();

	/**
	 * This method is used to set password of the user.
	 * @param password - the password of the user.
	 */
	void setPassword(String password);

	/**
	 * A method that indicates the first name  of the user.
	 * @return String that indicates the first name of the user.
	 */
	String getFirstName();

	/**
	 * This method is used to set first name of the user.
	 * @param firstName - first name of the user.
	 */
	void setFirstName(String firstName);

	/**
	 * A method that indicates the last name of the user.
	 * @return String that indicates the last name of the user.
	 */
	String getLastName();

	/**
	 *  This method is used to set last name of the user.
	 * @param lastName - last name of the user.
	 */
	void setLastName(String lastName);

	/**
	 *  A method that indicates the username of the user.
	 * @return String that indicates the username ot the user.
	 */
	String getUsername();
}
