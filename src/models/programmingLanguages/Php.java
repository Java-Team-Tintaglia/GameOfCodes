package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class Php extends ProgrammingLanguage {
	private static boolean exist;
	
    public Php(int x, int y) {
    	super(x, y, ProgrammingLanguageType.PHP, 9, 9, Assets.phpCharacter);
		this.exist=true;
    	}

	public  boolean isExist() {
		return exist;
	}

	public  void setExist(boolean exist) {
		Php.exist = exist;
	}
}
