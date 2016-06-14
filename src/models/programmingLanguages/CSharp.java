package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class CSharp extends ProgrammingLanguage{
	private static boolean exist;

	public CSharp(int x, int y) {
		super(x, y, ProgrammingLanguageType.C_SHARP, 5, 5, Assets.csharpCharacter);

	}
}
