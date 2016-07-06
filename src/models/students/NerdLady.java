package models.students;

import graphics.Assets;

public class NerdLady extends Student {
	
	private static final int NERD_LADY_WIDTH = 41;
	private static final int NERD_LADY_HEIGHT = 44;

	public NerdLady(int x, int y, String username) {
		super(x, y, Assets.nerdLadyPlayer, NERD_LADY_WIDTH, NERD_LADY_HEIGHT, 70, 60, 100, username);
	}
}
