package factories;

import enums.StudentType;
import interfaces.Student;
import interfaces.StudentFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by PetyoPetrov on 03.08.2016 г..
 */
public class FactoryTest {

    private static final int TEST_X_COORD = 100;
    private static final int TEST_Y_COORD = 100;

    @Test
    public void createStudent_FromStudentFactory_Correctness() {

        StudentFactory factory = new StudentFactoryImpl();
        Student student = factory.create(StudentType.BAD_BOY, TEST_X_COORD, TEST_Y_COORD, "TEST", "TEST");
        Assert.assertNotNull(student);

    }
}
