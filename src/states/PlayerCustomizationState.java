package states;

import java.awt.*;

import enums.StudentType;
import graphics.Assets;
import models.Button;
import repositories.UserRepository;
import utils.Constants;

public class PlayerCustomizationState extends State {

    public static StringBuilder stringBuilger = new StringBuilder();
    
    public static StudentType studentType;
    public static boolean isSelected = false;
    
    public static Button playButton = new Button(800, 520, Assets.buttonPlay);
    
    public static Button badBoyButton = new Button(74, 300, Assets.buttonBadBoy);
    public static Button hotChickButton = new Button(316, 300, Assets.buttonHotChick);
    public static Button nerdBoyButton = new Button(558, 300, Assets.buttonNerdBoy);
    public static Button nerdLadyButton = new Button(800, 300, Assets.buttonNerdLady);

   
    public PlayerCustomizationState(UserRepository userRepository) {
		super(userRepository);
	}

	@Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.playerCustomization, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.selectPlayer, 362, 30, 300, 70, null);

        Font textFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(textFont);
        graphics.setColor(Color.green);

        String name = "Enter Name:";
        graphics.drawString(name, 400, 410);
        graphics.fillRect(400, 420, 205, 40);

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
        graphics.drawString(stringBuilger.toString(), 410, 450);

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
