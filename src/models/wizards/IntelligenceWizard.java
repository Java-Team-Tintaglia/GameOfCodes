package models.wizards;

import enums.WizardType;
import models.students.Student;

public class IntelligenceWizard extends AbstractWizard{
    public IntelligenceWizard() {
        super(WizardType.INTELLIGENCE_WIZARD);
    }
    
    @Override
    public void boost(Student student) {
        int intelligence = student.getIntelligence() + 1;
        student.setVitality(intelligence);
    }
}
