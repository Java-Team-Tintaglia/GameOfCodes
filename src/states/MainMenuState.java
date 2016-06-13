package states;

import  java.awt.Graphics;

import graphics.Assets;
import models.Button;
import utils.Constants;

public class MainMenuState extends State {

    public static Button buttonStart =new Button(800,380, Assets.buttonStart);
    public static Button buttonScore = new Button(800,450,Assets.buttonScore);
    public static Button buttonExit = new Button(800,520,Assets.buttonExit);
    public static Button buttonPlay;

    @Override
    public void draw(Graphics graphics) {
    	graphics.drawImage(Assets.mainMenu, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

        buttonStart.draw(graphics);
        buttonScore.draw(graphics);
        buttonExit.draw(graphics);
    }

    @Override
    public void update() {
    }
}
