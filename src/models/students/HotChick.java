package models.students;

import graphics.Assets;

public class HotChick extends Student{
	
    private static final int HOT_CHICK_WIDTH = 40;
    private static final int HOT_CHICK_HEIGHT = 40;

    public HotChick(int x, int y, String username) {
        super(x, y, Assets.hotChickPlayer, HOT_CHICK_WIDTH, HOT_CHICK_HEIGHT, 60, 70, 100, username);
    }
}
