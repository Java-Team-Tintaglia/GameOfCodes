package models.wizards;

import enums.WizardType;
import graphics.Assets;
import interfaces.Student;

public class VitalityWizard extends AbstractWizard {

	private static final int DEFAUL_VITALITY_POINTS = 30;
	
	public VitalityWizard(int x , int y) {
        super(x, y, WizardType.VITALITY_WIZARD, Assets.wizardBeer);
    }
	
    @Override
    public void boost(Student student) {
        int vitality = student.getVitality() + DEFAUL_VITALITY_POINTS;
        student.setVitality(vitality);
    }
}
