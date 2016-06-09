package models.wizards;

import models.students.Student;

public class IntelligenceWizard extends AbstractWizard{
    public IntelligenceWizard() {
        super(WizardType.INTELLIGENCE);
    }
    @Override
    public void boost(Student student) {
        int intelligence = student.getIntelligence() + 1;
        student.setVitality(intelligence);
    }
}
