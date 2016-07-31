package base;

import constants.Common;
import core.GameEngine;

public class Launcher {

	public static void main(String[] args) {
		GameEngine game = new GameEngine(Common.GAME_TITLE);
        game.start();
	}
}
