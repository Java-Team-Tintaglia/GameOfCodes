package factories;

import enums.StudentType;
import models.students.BadBoy;
import models.students.HotChick;
import models.students.NerdBoy;
import models.students.NerdLady;
import models.students.Student;

public class StudentFactory {
	public Student create(StudentType type, int x ,int y, String name) {
		Student student = null;
		
		switch (type) {
		case NERD_LADY:
			student = new NerdLady(x, y, name);
			break;
		case NERD_BOY:
			student = new NerdBoy(x, y, name);
			break;
		case BAD_BOY:
			student = new BadBoy(x, y, name);
			break;
		case HOT_CHICK:
			student = new HotChick(x, y, name);
			break;

		}
		
		return student;
	}
	
}
