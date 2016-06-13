package states;

import java.awt.*;

import graphics.Assets;
import models.Button;
import utils.Constants;

public class PlayerCustomizationState extends State {

    public static StringBuilder stringBuilger = new StringBuilder();
    //public static StudentType studentType;
    public static Button playButton = new Button(800, 520, Assets.buttonPlay);

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.wall, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        Font textFont = new Font("Comic Sans MS", Font.ITALIC, 20);
        graphics.setFont(textFont);
        graphics.setColor(Color.black);

        Font buttonsFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(buttonsFont);
        graphics.drawString(stringBuilger.toString(), 500, 500);

        playButton.draw(graphics);
    }

    @Override
    public void update() {
    }
}
