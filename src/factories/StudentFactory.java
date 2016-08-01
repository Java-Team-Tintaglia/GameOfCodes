package factories;

import enums.StudentType;
import interfaces.Student;
import models.students.BadBoy;

import java.lang.reflect.Constructor;

public class StudentFactory {
	public Student create(StudentType type, int x, int y, String username) {
		Student student = null;

		if (type == null) {
			student = new BadBoy(x, y, username);
			return student;
		}

		try {
			Class<Student> classInfo = (Class<Student>) Class.forName(type.getClassName());
			Constructor<Student> ctor = classInfo.getConstructor(int.class, int.class, String.class);
			student = ctor.newInstance(x, y, username);
		} catch (ReflectiveOperationException roe) {
			roe.printStackTrace();
		}

		return student;
	}
	
}
