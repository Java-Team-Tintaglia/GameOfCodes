package factories;

import enums.StudentType;
import models.students.BadBoy;
import models.students.HotChick;
import models.students.NerdBoy;
import models.students.NerdLady;
import models.students.Student;

public class StudentFactory {
	private static final String DEFAULT_PLAYER_NAME = "player"; // no defaul should be authenticated

	public Student create(StudentType type, int x ,int y, String username) {
		Student student = null;

		if (username == null || username.equals("")) {
			username = DEFAULT_PLAYER_NAME;
		}

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
