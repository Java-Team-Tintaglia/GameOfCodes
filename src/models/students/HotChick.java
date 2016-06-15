package models.students;

import graphics.Assets;

public class HotChick extends Student{
    private static final int imageWidth = 40;
    private static final int imageHeidth = 40;

    public HotChick(int x, int y, String name)
    {
        super(x, y, Assets.hotchikplayer, imageWidth, imageHeidth, name, 70, 60, 120);
    }
}
