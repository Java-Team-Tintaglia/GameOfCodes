package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;


public class JavaScript extends ProgrammingLanguage {
    private static boolean exist;


    public JavaScript(int x, int y) {
        super(x, y, ProgrammingLanguageType.JAVA_SCRIPT, 6, 6, Assets.javascriptCharacter);

    }
}
