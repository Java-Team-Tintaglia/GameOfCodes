package interfaces;


import enums.StudentType;

/**
 * This interface defines the behaviour for creating a new Student.
 */

public interface StudentFactory {
	/**
	 * This method is used to create a new student.
	 * @param type creating a student type.
	 * @param x creating x coordinate.
	 * @param y creating y coordinate.
	 * @param username creating new username.
	 * @param fullName creating new fullname.
	 * @return new student.
	 */

	Student create(StudentType type, int x, int y, String username, String fullName);
}

