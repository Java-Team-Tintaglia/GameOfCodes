package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class Java extends ProgrammingLanguage {
    private static int VITALITY_DAMAGE_POINTS = 6;
    private static int KNOWLEDGE_POINTS = 5;
    public Java(int x, int y) {
        super(x, y, ProgrammingLanguageType.JAVA, VITALITY_DAMAGE_POINTS, KNOWLEDGE_POINTS, Assets.javaCharacter);

    }
}
