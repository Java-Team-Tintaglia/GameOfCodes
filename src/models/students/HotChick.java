package models.students;

import graphics.Assets;

public class HotChick extends Student{
	
    private static final int HOT_CHICK_WIDTH = 40;
    private static final int HOT_CHICK_HEIGHT = 40;
    private static final int INTELLIGENCE =60;
    private static final int KNOWLEDGE=70;
    private static final int VITALITY=100;
    public HotChick(int x, int y, String username) {
        super(x, y, Assets.hotChickPlayer, HOT_CHICK_WIDTH, HOT_CHICK_HEIGHT, INTELLIGENCE, KNOWLEDGE, VITALITY, username);
    }
}
