package models.wizards;

import enums.WizardType;
import models.students.Student;

public class VitalityWizard extends Wizard {
    private  boolean exist;
    
	public VitalityWizard(int x , int y) {
        super(x, y, WizardType.VITALITY_WIZARD);
        this.exist=true;
    }
	
    @Override
    public void boost(Student student) {
        int vitality = student.getVitality() + 10;
        student.setVitality(vitality);
    }

    public  boolean isExist() {
        return exist;
    }

    public  void setExist(boolean exist) {
        this.exist = exist;
    }
}
