package models.students;

import graphics.Assets;

public class NerdLady extends Student {
	
	private static final int imageWidth = 41;
	private static final int imageHeight = 44;

	public NerdLady(String firstName, String surname, String username, String password) {
		super(Assets.nerdLadyPlayer, imageWidth, imageHeight, 80, 70, 100, firstName, surname, username, password);
	}
}
