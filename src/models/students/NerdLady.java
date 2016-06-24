package models.students;

import graphics.Assets;

public class NerdLady extends Student {
	
	private static final int imageWidth = 41;
	private static final int imageHeight = 44;

	public NerdLady(int x, int y, String username) {
		super(x, y, Assets.nerdLadyPlayer, imageWidth, imageHeight, 80, 70, 100, username);
	}
}
