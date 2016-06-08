package base;

import core.GameEngine;

public class Launcher {

	public static void main(String[] args) {
		GameEngine game = new GameEngine("Game of Codes");
        game.start();
	}
}
