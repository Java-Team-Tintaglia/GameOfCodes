package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class JavaScript extends ProgrammingLanguage {
    private static final int VITALITY_DAMAGE_POINTS = 3;
    private static final int KNOWLEDGE_POINTS = 4;
    public JavaScript(int x, int y) {
        super(x, y, ProgrammingLanguageType.JAVA_SCRIPT, VITALITY_DAMAGE_POINTS, KNOWLEDGE_POINTS, Assets.javaScriptCharacter);

    }
}
