package core;

import org.junit.Assert;
import org.junit.Test;

import interfaces.ProgrammingLanguage;
import interfaces.Wizard;


public class MapInitializorTest {

	@Test
	public void testGenerateRandomProgrammingLanguageNotNull(){
		ProgrammingLanguage programmingLanguage = MapInitializor.generateProgrammingLanguage();
		Assert.assertNotNull(programmingLanguage);
	}
	
	@Test
	public void testGenerateRandomWizardNotNull(){
		Wizard wizard = MapInitializor.generateWizard();
		Assert.assertNotNull(wizard);
	}
	
}
