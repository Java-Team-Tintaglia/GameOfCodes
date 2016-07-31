package interfaces;

import enums.ProgrammingLanguageType;

public interface ProgrammingLanguage extends GameObject, Collidable, Existable {

	ProgrammingLanguageType getProgrammingLanguageType();
	
	int getVitalityDamagePoints();

	int getKnowledgePoints();
}
