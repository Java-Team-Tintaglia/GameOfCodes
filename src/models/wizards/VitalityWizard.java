package models.wizards;

import models.students.Student;

public class VitalityWizard extends AbstractWizard {
    public VitalityWizard() {
        super(WizardType.VITALITY);
    }
    @Override
    public void boost(Student student) {
        int vitality = student.getVitality() + 1;
        student.setVitality(vitality);
    }
}
