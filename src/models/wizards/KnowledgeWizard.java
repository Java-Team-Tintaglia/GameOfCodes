package models.wizards;

import enums.WizardType;
import graphics.Assets;
import models.students.Student;

public class KnowledgeWizard extends Wizard {
   
	public KnowledgeWizard(int x, int y) {
        super(x, y, WizardType.KNOWLEDGE_WIZARD, Assets.wizard);
    }
    
    @Override
    public void boost(Student student) {
        int knowledge = student.getKnowledge() + 5;
        student.setKnowledge(knowledge);
    }
}
