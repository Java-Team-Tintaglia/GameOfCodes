package core;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import graphics.Assets;
import interfaces.ProgrammingLanguage;
import interfaces.Student;
import interfaces.Wizard;
import models.programmingLanguages.Java;
import models.students.BadBoy;
import models.wizards.IntelligenceWizard;

@RunWith(MockitoJUnitRunner.class)
public class CollisionHandlerTest {

	private static final int X_COORD = 100;
	private static final int Y_COORD = 100;
	private static final int BAD_BOY_WIDTH = 39;
    private static final int BAD_BOY_HEIGHT = 40;
	private static final String USERNAME = "Username";
	private static final String FULL_NAME = "FullName";
	
	private Rectangle colliderBox;

	@Mock
	private Wizard wizard;
	
	@Mock
	private ProgrammingLanguage programmingLanguage;
	
	@Mock
	private Student mockedStudent;
	
	@Before
	public void setUp() {
		Assets.init();
		this.colliderBox = new Rectangle(X_COORD, Y_COORD, BAD_BOY_WIDTH, BAD_BOY_HEIGHT);
	}
	
	@Test
	public void testCollisionWizardWithStudentShouldBeBoosted() {
		Student student = new BadBoy(X_COORD, Y_COORD, USERNAME, FULL_NAME);
		Mockito.when(this.wizard.isExist()).thenReturn(true);
		Mockito.when(this.wizard.getCollideBox()).thenReturn(student.getCollideBox());
		
		CollisionHandler.handleCollisions(student, this.wizard, null);
		
		Mockito.verify(this.wizard).boost(student);
	}
	
	
}
