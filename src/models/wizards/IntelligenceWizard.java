package models.wizards;

import enums.WizardType;
import models.students.Student;

public class IntelligenceWizard extends Wizard{
    public IntelligenceWizard(int x , int y) {
        super(x, y, WizardType.INTELLIGENCE_WIZARD);
    }
    
    @Override
    public void boost(Student student) {
        int intelligence = student.getIntelligence() + 5;
        student.setVitality(intelligence);
    }

}
