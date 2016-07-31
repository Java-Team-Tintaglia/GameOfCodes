package models.students;

import graphics.Assets;

public class HotChick extends AbstractStudent {
	
    private static final int HOT_CHICK_WIDTH = 40;
    private static final int HOT_CHICK_HEIGHT = 40;
    private static final int HOT_CHICK_INTELLIGENCE = 60;
    private static final int HOT_CHICK_KNOWLEDGE = 70;
    private static final int HOT_CHICK_VITALITY = 100;
    
    public HotChick(int x, int y, String username) {
        super(x, y, Assets.hotChickPlayer, HOT_CHICK_WIDTH, HOT_CHICK_HEIGHT, 
        		HOT_CHICK_INTELLIGENCE, HOT_CHICK_KNOWLEDGE, HOT_CHICK_VITALITY, username);
    }
}
