package models.wizards;

import enums.WizardType;
import models.students.Student;

public class VitalityWizard extends Wizard {
    
	public VitalityWizard(int x , int y) {
        super(x, y, WizardType.VITALITY_WIZARD);
    }
	
    @Override
    public void boost(Student student) {
        int vitality = student.getVitality() + 10;
        student.setVitality(vitality);
    }
}
