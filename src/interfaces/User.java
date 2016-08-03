package interfaces;
/*
* <summary>
* 	This interface defines the behaviour for the new User.
* </summary>
* */

public interface User {
	/*
* <summary>
*     A method that indicates the password of the object.
* </summary>
* <returns>
* 	Returns String that indicates the password of the object.
* </returns>
* */
	String getPassword();

	/*
* <summary>
*     This method is used to set password.
* </summary>
* <parameters>
* 	<param type='String'>password</param>
* </parameters>
* */
	void setPassword(String password);

	/*
* <summary>
*     A method that indicates the first name  of the object.
* </summary>
* <returns>
* 	Returns String that indicates the first name of the object.
* </returns>
* */
	String getFirstName();
	/*
* <summary>
*     This method is used to set firstName.
* </summary>
* <parameters>
* 	<param type='String'>firstName</param>
* </parameters>
* */

	void setFirstName(String firstName);
	/*
* <summary>
*     A method that indicates the last name of the object.
* </summary>
* <returns>
* 	Returns String that indicates the last name of the object.
* </returns>
* */
	String getLastName();
	/*
* <summary>
*     This method is used to set lastName.
* </summary>
* <parameters>
* 	<param type='String'>lastName</param>
* </parameters>
* */
	void setLastName(String lastName);

	/*
* <summary>
*     A method that indicates the username of the object.
* </summary>
* <returns>
* 	Returns String that indicates the username ot the object.
* </returns>
* */
	String getUsername();
}
