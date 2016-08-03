package interfaces;

/**
 * This interface defines the behaviour for the new User.
 */

public interface User {
	/**
	 * A method that indicates the password of the object.
	 * @return String that indicates the password of the object.
	 */

	String getPassword();

	/**
	 * This method is used to set password of the object.
	 * @param password setting password of the object.
	 */


	void setPassword(String password);

	/**
	 * A method that indicates the first name  of the object.
	 * @return String that indicates the first name of the object.
	 */

	String getFirstName();

	/**
	 * This method is used to set firstName of the object.
	 * @param firstName setting firstName of the object.
	 */

	void setFirstName(String firstName);

	/**
	 * A method that indicates the last name of the object.
	 * @return String that indicates the last name of the object.
	 */

	String getLastName();

	/**
	 *  This method is used to set lastName of the object.
	 * @param lastName setting lastName of the object.
	 */
	void setLastName(String lastName);

	/**
	 *  A method that indicates the username of the object.
	 * @return String that indicates the username ot the object.
	 */

	String getUsername();
}
