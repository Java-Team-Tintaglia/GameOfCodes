package models.students;

import graphics.Assets;

public class BadBoy extends Student {
	
    private static final int BAD_BOY_WIDTH = 39;
    private static final int BAD_BOY_HEIGHT = 40;

    public BadBoy(int x, int y, String username) {
        super(x, y, Assets.badBoyPlayer, BAD_BOY_WIDTH, BAD_BOY_HEIGHT, 60, 70, 100, username);
    }
}
