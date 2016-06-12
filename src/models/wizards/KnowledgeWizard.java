package models.wizards;

import enums.WizardType;
import models.students.Student;

public class KnowledgeWizard extends Wizard {
	
    public KnowledgeWizard(int x, int y) {
        super(x, y, WizardType.KNOWLEDGE_WIZARD);
    }
    
    @Override
    public void boost(Student student) {
        int knowledge = student.getKnowledge() + 10;
        student.setVitality(knowledge);
    }
}
