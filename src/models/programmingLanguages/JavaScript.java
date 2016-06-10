package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;


public class JavaScript extends ProgrammingLanguage {

    public JavaScript(int x, int y) {
        super(x, y, ProgrammingLanguageType.JAVA_SCRIPT, 6, 6, Assets.javaCharacter);
    }

}
