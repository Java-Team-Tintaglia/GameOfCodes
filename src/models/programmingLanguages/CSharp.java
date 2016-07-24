package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class CSharp extends ProgrammingLanguage{
	private static final int VITALITY_DAMAGE_POINTS = 5;
	private static final int KNOWLEDGE_POINTS = 5;
	public CSharp(int x, int y) {
		super(x, y, ProgrammingLanguageType.C_SHARP, VITALITY_DAMAGE_POINTS, KNOWLEDGE_POINTS, Assets.cSharpCharacter);

	}
}
