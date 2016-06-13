package models.wizards;

import enums.WizardType;
import models.students.Student;

public class KnowledgeWizard extends Wizard {
    private  boolean exist;
	
    public KnowledgeWizard(int x, int y) {
        super(x, y, WizardType.KNOWLEDGE_WIZARD);
        this.exist=true;
    }
    
    @Override
    public void boost(Student student) {
        int knowledge = student.getKnowledge() + 10;
        student.setVitality(knowledge);
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
