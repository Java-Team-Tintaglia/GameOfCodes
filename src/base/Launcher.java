package base;

import constants.Common;
import core.GameEngineImpl;
import interfaces.GameEngine;

public class Launcher {

	public static void main(String[] args) {
		GameEngine game = new GameEngineImpl(Common.GAME_TITLE);
        game.start();
	}
}
