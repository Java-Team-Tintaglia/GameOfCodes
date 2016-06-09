package states;

import java.awt.Graphics;

import graphics.Assets;
import utils.Constants;

public class GameState extends State {

	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(Assets.wall, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.floor, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

		
	}

	@Override
	public void update() {
	}
	
}
