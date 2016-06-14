package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class Java extends ProgrammingLanguage {
    private static boolean exist;

    public Java(int x, int y) {
        super(x, y, ProgrammingLanguageType.JAVA, 7, 7, Assets.javaCharacter);

    }

    public  boolean isExist() {
        return exist;
    }

    public  void setExist(boolean exist) {
        Java.exist = exist;
    }
}
