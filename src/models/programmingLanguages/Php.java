package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class Php extends AbstractProgrammingLanguage {
	
	private static final int VITALITY_DAMAGE_POINTS = 6;
	private static final int KNOWLEDGE_POINTS = 3;
	
    public Php(int x, int y) {
    	super(x, y, 
    			ProgrammingLanguageType.PHP, 
    			VITALITY_DAMAGE_POINTS, 
    			KNOWLEDGE_POINTS, 
    			Assets.phpCharacter);
    	} 
}
