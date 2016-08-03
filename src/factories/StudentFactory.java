package factories;

import constants.Common;
import constants.Messages;
import enums.StudentType;
import interfaces.Student;

import java.lang.reflect.Constructor;

public class StudentFactory {
	public Student create(StudentType type, int x, int y, String username, String fullName) {
		Student student = null;

		String className = type == null ?
				Common.STUDENTS_PACKAGE + Common.DEFAULT_STUDENT_TYPE :
				Common.STUDENTS_PACKAGE + type.getClassName();

		try {
			@SuppressWarnings("unchecked")
			Class<Student> classInfo = (Class<Student>) Class.forName(className);
			Constructor<Student> ctor = classInfo.getConstructor(int.class, int.class, String.class, String.class);
			student = ctor.newInstance(x, y, username, fullName);
		} catch (ReflectiveOperationException roe) {
			String message = String.format(Messages.OBJECT_CREATION_FAILURE, className);
			System.err.println(message);
		}

		return student;
	}
}
