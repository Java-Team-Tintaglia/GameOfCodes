package models;

import org.junit.Assert;
import org.junit.Test;

import interfaces.Student;
import models.students.BadBoy;

public class StudentTest {

	@Test
	public void ConstructorStudentDifferentThanNull() {
		Student student = new BadBoy(100, 100, "TEST");
		Assert.assertNotNull(student);
	}

}
