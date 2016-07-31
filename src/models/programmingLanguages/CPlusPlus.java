package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class CPlusPlus extends AbstractProgrammingLanguage {
	
    private static final int VITALITY_DAMAGE_POINTS = 4;
    private static final int KNOWLEDGE_POINTS = 5;

    public CPlusPlus(int x, int y) {
        super(x, y, 
        		ProgrammingLanguageType.C_PLUS_PLUS, 
        		VITALITY_DAMAGE_POINTS, 
        		KNOWLEDGE_POINTS, 
        		Assets.cPlusPlusCharacter);
    }
}
