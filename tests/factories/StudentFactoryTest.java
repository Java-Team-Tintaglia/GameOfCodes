package factories;

import enums.StudentType;
import interfaces.Student;
import interfaces.StudentFactory;
import org.junit.Assert;
import org.junit.Test;


public class StudentFactoryTest {

    private static final int X_COORD = 100;
    private static final int Y_COORD = 100;
    private static final String USERNAME = "TEST";
    private static final String FULL_NAME = "TEST";

    @Test
    public void createStudentFromStudentFactoryShouldNotBeNull() {
        StudentFactory factory = new StudentFactoryImpl();
        Student student = factory.create(StudentType.BAD_BOY, X_COORD, Y_COORD, USERNAME, FULL_NAME);
        Assert.assertNotNull(student);

    }
    
    @Test
    public void createDefaultStudentWhenTypeIsNull() {
        StudentFactory factory = new StudentFactoryImpl();
        Student student = factory.create(null, X_COORD, Y_COORD, USERNAME, FULL_NAME);
        Assert.assertNotNull(student);

    }
    
}
