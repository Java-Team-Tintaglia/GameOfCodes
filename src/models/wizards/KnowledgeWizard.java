package models.wizards;

import enums.WizardType;
import models.students.Student;

public class KnowledgeWizard extends AbstractWizard {
	
    public KnowledgeWizard() {
        super(WizardType.KNOWLEDGE_WIZARD);
    }
    
    @Override
    public void boost(Student student) {
        int knowledge = student.getKnowledge() + 1;
        student.setVitality(knowledge);
    }
}
