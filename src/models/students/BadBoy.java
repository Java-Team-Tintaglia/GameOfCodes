package models.students;

import graphics.Assets;

public class BadBoy extends StudentImpl {
	
    private static final int BAD_BOY_WIDTH = 39;
    private static final int BAD_BOY_HEIGHT = 40;
    private static final int INTELLIGENCE =60;
    private static final int KNOWLEDGE=70;
    private static final int VITALITY=100;



    public BadBoy(int x, int y, String username) {
        super(x, y, Assets.badBoyPlayer, BAD_BOY_WIDTH, BAD_BOY_HEIGHT,
                INTELLIGENCE, KNOWLEDGE, VITALITY, username);

    }
}
