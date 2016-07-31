package models.students;

import graphics.Assets;

public class NerdBoy extends AbstractStudent {

    public static final int NERD_BOY_WIDTH = 50;
    public static final int NERD_BOY_HEIGHT = 49;
    private static final int NERD_BOY_INTELLIGENCE = 70;
    private static final int NERD_BOY_KNOWLEDGE = 60;
    private static final int NERD_BOY_VITALITY = 100;
    
    public NerdBoy(int x, int y, String username) {
        super(x, y, Assets.nerdBoyPlayer, NERD_BOY_WIDTH, NERD_BOY_HEIGHT, 
        		NERD_BOY_INTELLIGENCE, NERD_BOY_KNOWLEDGE, NERD_BOY_VITALITY, username);
    }
}
