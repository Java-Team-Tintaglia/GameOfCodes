package models;

import interfaces.Student;
import models.students.BadBoy;
import models.students.HotChick;
import models.students.NerdBoy;
import models.students.NerdLady;
import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    private static final String USERNAME = "testUsername";
    private static final String FULL_NAME = "testFullName";
    private static final int TEST_X = 100;
    private static final int TEST_Y = 100;

    //region Constructor Tests
	@Test
    public void testBadBoyConstructorReturnsCorrectStudent() {
	    Student student = new BadBoy(TEST_X, TEST_Y, USERNAME, FULL_NAME);
        Assert.assertEquals(BadBoy.class, student.getClass());
    }

    @Test
    public void testBadBoyConstructorDifferentThanNull() {
        Student student = new BadBoy(TEST_X, TEST_Y, USERNAME, FULL_NAME);
        Assert.assertNotNull(student);
    }

    @Test
    public void testHotChickConstructorReturnsCorrectStudent() {
        Student student = new HotChick(TEST_X, TEST_Y, USERNAME, FULL_NAME);
        Assert.assertEquals(HotChick.class, student.getClass());
    }

    @Test
    public void testHotChickConstructorDifferentThanNull() {
        Student student = new HotChick(TEST_X, TEST_Y, USERNAME, FULL_NAME);
        Assert.assertNotNull(student);
    }

    @Test
    public void testNerdBoyConstructorReturnsCorrectStudent() {
        Student student = new NerdBoy(TEST_X, TEST_Y, USERNAME, FULL_NAME);
        Assert.assertEquals(NerdBoy.class, student.getClass());
    }

    @Test
    public void testNerdBoyConstructorDifferentThanNull() {
        Student student = new NerdBoy(TEST_X, TEST_Y, USERNAME, FULL_NAME);
        Assert.assertNotNull(student);
    }

    @Test
    public void testNerdLadyConstructorReturnsCorrectStudent() {
        Student student = new NerdLady(TEST_X, TEST_Y, USERNAME, FULL_NAME);
        Assert.assertEquals(NerdLady.class, student.getClass());
    }

    @Test
    public void testNerdLadyConstructorDifferentThanNull() {
        Student student = new NerdLady(TEST_X, TEST_Y, USERNAME, FULL_NAME);
        Assert.assertNotNull(student);
    }
    //endregion
}
