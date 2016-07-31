package models.wizards;

import enums.WizardType;
import graphics.Assets;
import interfaces.Student;
import models.students.StudentImpl;

public class VitalityWizard extends WizardImpl {

	public VitalityWizard(int x , int y) {
        super(x, y, WizardType.VITALITY_WIZARD, Assets.wizardBeer);
    }
	
    @Override
    public void boost(Student student) {
        int vitality = student.getVitality() + 30;
        student.setVitality(vitality);
    }
}
