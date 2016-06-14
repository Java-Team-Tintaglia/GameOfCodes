package models.students;

import graphics.Assets;

public class HotChick extends Student{
    private static int imageWidth=40;
    private static int imageHeidth=40;
//da se opravi obraza
    public HotChick(int x, int y, String name)
    {
        super(x, y, Assets.hotchikplayer, imageWidth, imageHeidth, name, 70, 60, 120);
    }
}
