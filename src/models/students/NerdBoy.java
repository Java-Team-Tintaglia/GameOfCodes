package models.students;

import graphics.Assets;

public class NerdBoy extends Student {

    public static final int NERDBOY_WIDTH = 50;
    public static final int NERDBOY_HEIGHT = 49;

    public NerdBoy(int x, int y, String username) {
        super(x, y, Assets.nerdBoyPlayer, NERDBOY_WIDTH, NERDBOY_HEIGHT, 80, 70, 100, username);
    }
}
