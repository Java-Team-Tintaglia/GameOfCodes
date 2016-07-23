package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class JavaScript extends ProgrammingLanguage {
    private static int VITALITY_DAMAGE_POINTS = 3;
    private static int KNOWLEDGE_POINTS = 4;
    public JavaScript(int x, int y) {
        super(x, y, ProgrammingLanguageType.JAVA_SCRIPT, VITALITY_DAMAGE_POINTS, KNOWLEDGE_POINTS, Assets.javaScriptCharacter);

    }
}
