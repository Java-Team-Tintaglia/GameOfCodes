package models.wizards;

import enums.WizardType;
import models.students.Student;

public class IntelligenceWizard extends Wizard{
    private boolean exist;

    public IntelligenceWizard(int x , int y) {
        super(x, y, WizardType.INTELLIGENCE_WIZARD);
        this.exist=true;
    }
    
    @Override
    public void boost(Student student) {
        int intelligence = student.getIntelligence() + 5;
        student.setVitality(intelligence);
    }

    @Override
    public boolean isExist() {
        return exist;
    }

    @Override
    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
