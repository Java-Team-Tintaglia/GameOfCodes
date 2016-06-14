package states;

import java.awt.*;

import graphics.Assets;
import models.Button;
import utils.Constants;

public class PlayerCustomizationState extends State {

    public static StringBuilder stringBuilger = new StringBuilder();
    //public static StudentType studentType;
    public static Button playButton = new Button(800, 520, Assets.buttonPlay);
    public static Button badBoyButton = new Button(74, 400, Assets.buttonBadBoy);
    public static Button hotChickButton = new Button(316, 400, Assets.buttonHotChick);
    public static Button nerdBoyButton = new Button(558, 400, Assets.buttonNerdBoy);
    public static Button nerdLadyButton = new Button(800, 400, Assets.buttonNerdLady);

    public static String name = "Enter Name:";

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.playerCustomization, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.selectPlayer, 362, 30, 300, 70, null);

        Font textFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(textFont);
        graphics.setColor(Color.green);

        graphics.drawString(name, 74, 500);
        graphics.fillRect(74, 520, 205, 40);
        graphics.drawRect(306, 390, 166, 60);

        graphics.setColor(Color.black);
//        Font buttonsFont = new Font("Comic Sans MS", Font.BOLD, 20);
//        graphics.setFont(buttonsFont);
        graphics.drawString(stringBuilger.toString(), 84, 545);

        playButton.draw(graphics);
        badBoyButton.draw(graphics);
        hotChickButton.draw(graphics);
        nerdBoyButton.draw(graphics);
        nerdLadyButton.draw(graphics);
    }

    @Override
    public void update() {
    }
}
