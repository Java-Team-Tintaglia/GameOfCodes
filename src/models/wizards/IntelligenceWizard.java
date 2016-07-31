package models.wizards;

import enums.WizardType;
import graphics.Assets;
import interfaces.Student;

public class IntelligenceWizard extends AbstractWizard {

	private static final int DEFAUL_INTELLIGENCE_POINTS = 5;
	
    public IntelligenceWizard(int x , int y) {
        super(x, y, WizardType.INTELLIGENCE_WIZARD , Assets.wizard);
    }

    @Override
    public void boost(Student student) {
        int intelligence = student.getIntelligence() + DEFAUL_INTELLIGENCE_POINTS;
        student.setIntelligence(intelligence);
    }
}
