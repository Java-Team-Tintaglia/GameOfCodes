package states;

import java.awt.Graphics;

import core.GameEngine;
import eventhandler.MouseInput;
import graphics.Assets;
import graphics.Display;
import utils.Constants;

public class GameState extends State {


    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.wall, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.floor, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        renderPlayer(graphics);


    }

    @Override
    public void update() {
    }

    public void renderPlayer(Graphics graphics) {
        

    }

}
