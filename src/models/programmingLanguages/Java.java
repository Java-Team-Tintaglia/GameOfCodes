package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class Java extends AbstractProgrammingLanguage {
	
    private static final int VITALITY_DAMAGE_POINTS = 6;
    private static final int KNOWLEDGE_POINTS = 5;
    
    public Java(int x, int y) {
        super(x, y, 
        		ProgrammingLanguageType.JAVA, 
        		VITALITY_DAMAGE_POINTS, 
        		KNOWLEDGE_POINTS, 
        		Assets.javaCharacter);

    }
}
