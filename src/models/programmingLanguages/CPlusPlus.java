package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

import java.awt.image.BufferedImage;

public class CPlusPlus extends ProgrammingLanguage {
    private static boolean exist;

    public CPlusPlus(int x, int y) {
        super(x, y, ProgrammingLanguageType.C_PLUS_PLUS, 10, 10, Assets.cplusplusCharacter);

    }

    public  boolean isExist() {
        return exist;
    }

    public  void setExist(boolean exist) {
        CPlusPlus.exist = exist;
    }
}
