package models.wizards;

import enums.WizardType;
import graphics.Assets;
import interfaces.Student;

public class KnowledgeWizard extends AbstractWizard {
   
	private static final int DEFAUL_KNOWLEDGE_POINTS = 5;
	
	public KnowledgeWizard(int x, int y) {
        super(x, y, WizardType.KNOWLEDGE_WIZARD, Assets.wizard);
    }
    
    @Override
    public void boost(Student student) {
        int knowledge = student.getKnowledge() + DEFAUL_KNOWLEDGE_POINTS;
        student.setKnowledge(knowledge);
    }
}
