package models.wizards;

import enums.WizardType;
import graphics.Assets;
import models.students.Student;

public class IntelligenceWizard extends WizardImpl {

    public IntelligenceWizard(int x , int y) {
        super(x, y, WizardType.INTELLIGENCE_WIZARD , Assets.wizard);
    }

    @Override
    public void boost(Student student) {
        int intelligence = student.getIntelligence() + 5;
        student.setIntelligence(intelligence);
    }
}
