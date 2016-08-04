package interfaces;


import enums.StudentType;

/**
 * This interface defines the behavior for creating a new Student.
 */
public interface StudentFactory {
	
	/**
	 * This method is used to create a new student.
	 * @param type on which depends what kind of student will be created.
	 * @param x coordinate.
	 * @param y coordinate.
	 * @param username.
	 * @param fullName.
	 * @return the newly created student.
	 */
	Student create(StudentType type, int x, int y, String username, String fullName);
}

