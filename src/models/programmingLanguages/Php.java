package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class Php extends ProgrammingLanguage {
	
    public Php(int x, int y) { 
    	super(x, y, ProgrammingLanguageType.PHP, 9, 9, Assets.javaCharacter); 
    	}
}
