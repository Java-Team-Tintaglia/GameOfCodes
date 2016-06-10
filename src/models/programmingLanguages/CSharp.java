package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class CSharp extends ProgrammingLanguage{

	public CSharp(int x, int y) {
		super(x, y, ProgrammingLanguageType.C_SHARP, 5, 5, Assets.javaCharacter);
	}
}
