package states;

import java.awt.*;

import enums.StudentType;
import graphics.Assets;
import models.Button;
import utils.Constants;

public class PlayerCustomizationState extends State {

    public static StringBuilder stringBuilger = new StringBuilder();
    
    public static StudentType studentType;
    public static boolean isSelected = false;
    
    public static Button playButton = new Button(800, 520, Assets.buttonPlay);
    public static Button badBoyButton = new Button(74, 400, Assets.buttonBadBoy);
    public static Button hotChickButton = new Button(316, 400, Assets.buttonHotChick);
    public static Button nerdBoyButton = new Button(558, 400, Assets.buttonNerdBoy);
    public static Button nerdLadyButton = new Button(800, 400, Assets.buttonNerdLady);

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.playerCustomization, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.selectPlayer, 362, 30, 300, 70, null);

        Font textFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(textFont);
        graphics.setColor(Color.green);

        String name = "Enter Name:";
        graphics.drawString(name, 80, 500);
        graphics.fillRect(74, 520, 205, 40);

        if (isSelected) {
            switch (studentType) {
                case BAD_BOY:
                    graphics.drawRect(64, 390, 170, 60);
                    break;
                case HOT_CHICK:
                    graphics.drawRect(306, 390, 170, 60);
                    break;
                case NERD_BOY:
                    graphics.drawRect(548, 390, 170, 60);
                    break;
                case NERD_LADY:
                    graphics.drawRect(790, 390, 170, 60);
                    break;
            }
        }

        graphics.setColor(Color.black);
        graphics.drawString(stringBuilger.toString(), 80, 545);

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
