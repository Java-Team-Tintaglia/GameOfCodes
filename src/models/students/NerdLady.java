package models.students;

import graphics.Assets;

public class NerdLady extends AbstractStudent {
	
	private static final int NERD_LADY_WIDTH = 41;
	private static final int NERD_LADY_HEIGHT = 44;
	private static final int NERD_LADY_INTELLIGENCE = 70;
	private static final int NERD_LADY_KNOWLEDGE = 60;
	private static final int NERD_LADY_VITALITY = 100;
	
	public NerdLady(int x, int y, String username) {
		super(x, y, Assets.nerdLadyPlayer, NERD_LADY_WIDTH, NERD_LADY_HEIGHT, 
				NERD_LADY_INTELLIGENCE, NERD_LADY_KNOWLEDGE, NERD_LADY_VITALITY, username);
	}
}
