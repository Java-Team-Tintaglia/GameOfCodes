package states;

import  java.awt.Graphics;

import graphics.Assets;
import models.Button;


public class MainMenuState extends State{

    public static Button buttonPlay =new Button(330,215, Assets.buttonPlay);
    public static Button buttonScore = new Button(330,283,Assets.buttonScore);
    public static Button buttonExit = new Button(330,351,Assets.buttonExit);

    @Override
    public void draw(Graphics graphics) {
        //on black background

        buttonPlay.draw(graphics);
        buttonScore.draw(graphics);
        buttonExit.draw(graphics);
    }

    @Override
    public void update() {

    }
}
