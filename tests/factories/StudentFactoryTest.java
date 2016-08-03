package factories;

import enums.StudentType;
import interfaces.Student;
import interfaces.StudentFactory;
import org.junit.Assert;
import org.junit.Test;


public class StudentFactoryTest {

    private static final int TEST_X_COORD = 100;
    private static final int TEST_Y_COORD = 100;
    private static final String TEST_NAME = "TEST";
    private static final String TEST_FULL_NAME = "TEST";

    @Test
    public void createStudentFromStudentFactoryShouldNotBeNull() {

        StudentFactory factory = new StudentFactoryImpl();
        Student student = factory.create(StudentType.BAD_BOY, TEST_X_COORD, TEST_Y_COORD, TEST_NAME, TEST_FULL_NAME);
        Assert.assertNotNull(student);

    }
}
