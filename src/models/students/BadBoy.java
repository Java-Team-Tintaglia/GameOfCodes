package models.students;

import graphics.Assets;

public class BadBoy extends AbstractStudent {
	
    private static final int BAD_BOY_WIDTH = 39;
    private static final int BAD_BOY_HEIGHT = 40;
    private static final int BAD_BOY_INTELLIGENCE = 60;
    private static final int BAD_BOY_KNOWLEDGE = 70;
    private static final int BAD_BOY_VITALITY = 100;

    public BadBoy(int x, int y, String username, String fullName) {
        super(x, y, Assets.badBoyPlayer, BAD_BOY_WIDTH, BAD_BOY_HEIGHT,
        		BAD_BOY_INTELLIGENCE, BAD_BOY_KNOWLEDGE, BAD_BOY_VITALITY, username, fullName);

    }
}
