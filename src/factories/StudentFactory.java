package factories;

import enums.StudentType;
import models.students.BadBoy;
import models.students.HotChick;
import models.students.NerdBoy;
import models.students.NerdLady;
import models.students.Student;

public class StudentFactory {
	private static final String DEFAULT_PLAYER_NAME = "player";

	public Student create(StudentType type, int x ,int y, String name) {
		Student student = null;

		if (name == null || name.equals("")) {
			name = DEFAULT_PLAYER_NAME;
		}

		if (type == null) {
			student = new BadBoy(x, y, DEFAULT_PLAYER_NAME);
			return student;
		}
		
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
