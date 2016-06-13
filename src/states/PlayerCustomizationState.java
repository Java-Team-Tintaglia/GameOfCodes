package states;

import java.awt.*;

import graphics.Assets;
import models.Button;
import utils.Constants;

public class PlayerCustomizationState extends State {

    public static StringBuilder stringBuilger = new StringBuilder();
    //public static StudentType studentType;
    public static Button playButton = new Button(800, 520, Assets.buttonPlay);
    public static Button nerdLadyCharacter = new Button(30, 200, Assets.nerdLady);
    public static Button badBoyCharacter = new Button(220, 200, Assets.badBoy);
    public static Button hotGirlCharacter = new Button(410, 200, Assets.hotChick);
    public static Button nerdBoyCharacter = new Button(610, 280, Assets.nerdBoy);
    public static Button playerSelectMessage = new Button(30, 90, Assets.playerSelectText);

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.wall, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        // Font textFont = new Font("Comic Sans MS", Font.ITALIC, 20);
        // graphics.setFont(textFont);
        // graphics.setColor(Color.black);

        // Font buttonsFont = new Font("Comic Sans MS", Font.BOLD, 20);
        // graphics.setFont(buttonsFont);
        // graphics.drawString(StringBuilder.toString(), 500, 500);

        playerSelectMessage.draw(graphics);

        nerdLadyCharacter.draw(graphics);
        badBoyCharacter.draw(graphics);
        hotGirlCharacter.draw(graphics);
        nerdBoyCharacter.draw(graphics);

        playButton.draw(graphics);
    }

    @Override
    public void update() {
    }
}
