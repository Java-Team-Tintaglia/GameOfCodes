package states;

import authentication.AuthenticationProvider;
import enums.StudentType;
import graphics.Assets;
import models.Button;
import utils.Constants;

import java.awt.*;

public class PlayerCustomizationState extends State {

    public static StudentType studentType;
    public static boolean isSelected = false;
    
    public static Button playButton = new Button(496, 510, Assets.buttonPlay);
    public static Button backToMenuButton = new Button(712, 510, Assets.buttonBackToMenu);
    
    public static Button badBoyButton = new Button(74, 300, Assets.buttonBadBoy);
    public static Button hotChickButton = new Button(316, 300, Assets.buttonHotChick);
    public static Button nerdBoyButton = new Button(558, 300, Assets.buttonNerdBoy);
    public static Button nerdLadyButton = new Button(800, 300, Assets.buttonNerdLady);

	@Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.playerCustomization, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.selectPlayer, 362, 30, 300, 70, null);

        Font textFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(textFont);
        graphics.setColor(Color.green);

        if (isSelected) {
            switch (studentType) {
                case BAD_BOY:
                    graphics.drawRect(64, 290, 170, 60);
                    break;
                case HOT_CHICK:
                    graphics.drawRect(306, 290, 170, 60);
                    break;
                case NERD_BOY:
                    graphics.drawRect(548, 290, 170, 60);
                    break;
                case NERD_LADY:
                    graphics.drawRect(790, 290, 170, 60);
                    break;
            }
        }

        graphics.setColor(Color.black);

        if (AuthenticationProvider.currentUser != null) {
        	Font title = new Font("Comic Sans MS", Font.PLAIN, 20);
            graphics.setFont(title);
            graphics.setColor(Color.green);
    		graphics.fillRect(880, 10, 150, 30);
    		
    		graphics.setColor(Color.white);
    		graphics.drawString(AuthenticationProvider.currentUser.getUsername(), 900, 30);
		}
        playButton.draw(graphics);
        backToMenuButton.draw(graphics);
        badBoyButton.draw(graphics);
        hotChickButton.draw(graphics);
        nerdBoyButton.draw(graphics);
        nerdLadyButton.draw(graphics);
    }

    @Override
    public void update() {
    }
}
