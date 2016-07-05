package models.students;

import graphics.Assets;

public class HotChick extends Student{
    private static final int imageWidth = 40;
    private static final int imageHeidth = 40;

    public HotChick(int x, int y, String username) {
        super(x, y, Assets.hotChickPlayer, imageWidth, imageHeidth, 70, 80, 100, username);
    }
}
