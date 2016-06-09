package models.students;

import graphics.Assets;

import static graphics.Assets.hotChick;

public class HotChick extends Student{
    public HotChick(int x, int y, String name) {
        super(x, y, hotChick, 0, 0, name, 70, 60, 120);
    }
}
