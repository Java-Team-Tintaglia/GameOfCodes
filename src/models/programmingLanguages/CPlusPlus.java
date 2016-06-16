package models.programmingLanguages;

import enums.ProgrammingLanguageType;
import graphics.Assets;

public class CPlusPlus extends ProgrammingLanguage {

    public CPlusPlus(int x, int y) {
        super(x, y, ProgrammingLanguageType.C_PLUS_PLUS, 4, 5, Assets.cPlusPlusCharacter);

    }
}
