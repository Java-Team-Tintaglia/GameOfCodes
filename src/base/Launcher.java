package base;

import core.GameEngine;
import utils.Constants;

public class Launcher {

	public static void main(String[] args) {
		GameEngine game = new GameEngine(Constants.GAME_TITLE);
        game.start();
	}
}
