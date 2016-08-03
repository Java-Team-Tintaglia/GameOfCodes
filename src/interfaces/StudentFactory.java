package interfaces;


import enums.StudentType;
/*
* <summary>
*     This interface defines the behaviour for creating a new Student.
* </summary>
*/

public interface StudentFactory {
	/*
	* <summary>
	*     This method is used to create a new student.
	* </summary>
	* <parameters>
	*    <param type='StudentType'>type</param> ???
	* 	<param type='int'>x</param>
	* 	<param type='int'>y</param>
	* 	<param type='String'>username</param>
	* 	<param type='String'>fullName</param>
	* </parameters>
	* */
	Student create(StudentType type, int x, int y, String username, String fullName);
}

