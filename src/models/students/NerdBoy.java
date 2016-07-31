package models.students;

import graphics.Assets;

public class NerdBoy extends AbstractStudent {

    public static final int NERDBOY_WIDTH = 50;
    public static final int NERDBOY_HEIGHT = 49;
    private static final int INTELLIGENCE =70;
    private static final int KNOWLEDGE=60;
    private static final int VITALITY=100;
    public NerdBoy(int x, int y, String username) {
        super(x, y, Assets.nerdBoyPlayer, NERDBOY_WIDTH, NERDBOY_HEIGHT, INTELLIGENCE, KNOWLEDGE, VITALITY, username);
    }
}
