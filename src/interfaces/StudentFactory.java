package interfaces;

import enums.StudentType;

public interface StudentFactory {
	Student create(StudentType type, int x, int y, String username, String fullName);
}
