package states;

import java.awt.*;

import graphics.Assets;
import models.Button;
import utils.Constants;

public class PlayerCustomizationState extends State {

    public static StringBuilder stringBuilger = new StringBuilder();
    //public static StudentType studentType;
    public static Button playButton = new Button(800, 520, Assets.buttonPlay);

    public static String name = "Enter Name:";

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.playerCustomization, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.selectPlayer, 362, 30, 300, 70, null);

        Font textFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(textFont);
        graphics.setColor(Color.white);

        graphics.drawString(name, 800, 400);
        graphics.fillRect(800, 410, 205, 40);
        graphics.setColor(Color.black);

//        Font buttonsFont = new Font("Comic Sans MS", Font.BOLD, 20);
//        graphics.setFont(buttonsFont);
        graphics.drawString(stringBuilger.toString(), 805, 435);

        playButton.draw(graphics);
    }

    @Override
    public void update() {
    }
}
