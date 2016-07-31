package factories;

import enums.StudentType;
import interfaces.Student;
import models.students.BadBoy;
import models.students.HotChick;
import models.students.NerdBoy;
import models.students.NerdLady;

public class StudentFactory {
	public Student create(StudentType type, int x, int y, String username) {
		Student student = null;

		if (type == null) {
			student = new BadBoy(x, y, username);
			return student;
		}
		
		switch (type) {
		case NERD_LADY:
			student = new NerdLady(x, y, username);
			break;
		case NERD_BOY:
			student = new NerdBoy(x, y, username);
			break;
		case BAD_BOY:
			student = new BadBoy(x, y, username);
			break;
		case HOT_CHICK:
			student = new HotChick(x, y, username);
			break;

		}
		
		return student;
	}
	
}
