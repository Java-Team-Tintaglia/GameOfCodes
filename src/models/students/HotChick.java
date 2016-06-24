package models.students;

import graphics.Assets;

public class HotChick extends Student{
    private static final int imageWidth = 40;
    private static final int imageHeidth = 40;

    public HotChick(String firstName, String surname, String username, String password) {
        super(Assets.hotChickPlayer, imageWidth, imageHeidth, 70, 60, 120, firstName, surname, username, password);
    }
}
