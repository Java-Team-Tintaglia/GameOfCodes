package models.wizards;

import enums.WizardType;
import models.students.Student;

public class VitalityWizard extends AbstractWizard {
    
	public VitalityWizard() {
        super(WizardType.VITALITY_WIZARD);
    }
	
    @Override
    public void boost(Student student) {
        int vitality = student.getVitality() + 1;
        student.setVitality(vitality);
    }
}
