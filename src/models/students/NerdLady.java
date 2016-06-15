package models.students;

import graphics.Assets;

public class NerdLady extends Student {
	
	private static final int imageWidth = 41;
	private static final int imageHeight = 44;

	public NerdLady(int x, int y, String name) {
		super(x, y, Assets.nerdladyplayer, imageWidth, imageHeight, name, 80, 70, 100);
	}
}
