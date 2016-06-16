package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class Java extends ProgrammingLanguage {

    public Java(int x, int y) {
        super(x, y, ProgrammingLanguageType.JAVA, 6, 5, Assets.javaCharacter);

    }
}
