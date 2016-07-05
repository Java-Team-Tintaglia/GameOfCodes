package models.students;

import graphics.Assets;

public class BadBoy extends Student {
    private static final int imageWidth = 39;
    private static final int imageHeidth = 40;

    public BadBoy(int x, int y, String username) {
        super(x, y, Assets.badBoyPlayer, imageWidth, imageHeidth, 70, 80, 100, username);
    }
}
