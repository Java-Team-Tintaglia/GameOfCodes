package models.students;

import graphics.Assets;

public class BadBoy extends Student {
    private static final int imageWidth = 39;
    private static final int imageHeidth = 40;

    public BadBoy(String firstName, String surname, String username, String password) {
        super(Assets.badBoyPlayer, imageWidth, imageHeidth, 60, 60, 130, firstName, surname, username, password);
    }
}
