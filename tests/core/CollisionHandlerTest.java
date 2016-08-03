package core;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import enums.Grades;
import graphics.Assets;
import interfaces.ProgrammingLanguage;
import interfaces.Student;
import interfaces.Wizard;
import models.students.BadBoy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CollisionHandlerTest {

	private static final int X_COORD = 100;
	private static final int Y_COORD = 100;
	private static final int BAD_BOY_WIDTH = 39;
    private static final int BAD_BOY_HEIGHT = 40;
	private static final String USERNAME = "Username";
	private static final String FULL_NAME = "FullName";
	
	private Rectangle colliderBox;
    private List<ProgrammingLanguage> languages;

	@Mock
	private Wizard mockedWizard;
	
	@Mock
	private ProgrammingLanguage mockedProgrammingLanguage;
	
	@Mock
	private Student mockedStudent;
	
	@Before
	public void setUp() {
		Assets.init();
		this.colliderBox = new Rectangle(X_COORD, Y_COORD, BAD_BOY_WIDTH, BAD_BOY_HEIGHT);
        this.languages = new ArrayList<>();
	}
	
	@Test
	public void testCollisionWizardWithStudentShouldBeBoosted() {
		Student student = new BadBoy(X_COORD, Y_COORD, USERNAME, FULL_NAME);
		Mockito.when(this.mockedWizard.isExist()).thenReturn(true);
		Mockito.when(this.mockedWizard.getCollideBox()).thenReturn(student.getCollideBox());
		
		CollisionHandler.handleCollisions(student, this.mockedWizard, this.languages);
		
		Mockito.verify(this.mockedWizard).boost(student);
	}
	
	@Test
    public void testCollisionLanguageWithStudentShouldCalculateGrade() {
        this.languages.add(this.mockedProgrammingLanguage);
        Mockito.when(this.mockedStudent.getCollideBox()).thenReturn(this.colliderBox);
        Mockito.when(this.mockedProgrammingLanguage.getCollideBox()).thenReturn(this.colliderBox);
        Mockito.when(this.mockedProgrammingLanguage.isExist()).thenReturn(true);

        CollisionHandler.handleCollisions(this.mockedStudent, this.mockedWizard, this.languages);

        Mockito.verify(this.mockedStudent).calculateGrade();
    }

    @Test
    public void testCollisionLanguageWithStudentShouldAddScore() {
        this.languages.add(this.mockedProgrammingLanguage);
        Mockito.when(this.mockedStudent.getCollideBox()).thenReturn(this.colliderBox);
        Mockito.when(this.mockedProgrammingLanguage.getCollideBox()).thenReturn(this.colliderBox);
        Mockito.when(this.mockedProgrammingLanguage.isExist()).thenReturn(true);
        Mockito.when(this.mockedStudent.calculateGrade()).thenReturn(Grades.VERY_GOOD.getGrade());

        CollisionHandler.handleCollisions(this.mockedStudent, this.mockedWizard, this.languages);

        Mockito.verify(this.mockedStudent).addScore(Grades.VERY_GOOD.getGrade(), this.mockedProgrammingLanguage);
    }

    @Test
    public void testCollisionLanguageWithStudentShouldSetStats() {
        this.languages.add(this.mockedProgrammingLanguage);
        Mockito.when(this.mockedStudent.getCollideBox()).thenReturn(this.colliderBox);
        Mockito.when(this.mockedProgrammingLanguage.getCollideBox()).thenReturn(this.colliderBox);
        Mockito.when(this.mockedProgrammingLanguage.isExist()).thenReturn(true);
        Mockito.when(this.mockedStudent.calculateGrade()).thenReturn(Grades.FAILURE.getGrade());

        CollisionHandler.handleCollisions(this.mockedStudent, this.mockedWizard, this.languages);

        Mockito.verify(this.mockedStudent).setStatsValues(Grades.FAILURE.getGrade(), this.mockedProgrammingLanguage);
    }
}
