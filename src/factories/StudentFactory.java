package factories;

import models.students.BadBoy;
import models.students.HotChick;
import models.students.NerdBoy;
import models.students.NerdLady;
import models.students.Student;

public class StudentFactory {
	public static Student student;
	public Student create(String type, int x ,int y, String name) {
		 student = null;
		
		switch (type) {
		case "nerdLady":
			student = new NerdLady(x, y, name);
			break;
		case "nerdBoy":
			student = new NerdBoy(x, y, name);
			break;
		case "badBoy":
			student = new BadBoy(x, y, name);
			break;
		case "hotChick":
			student = new HotChick(x, y, name);
			break;

		}
		
		return student;
	}
	
}
