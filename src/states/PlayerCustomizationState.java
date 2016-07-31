package states;

import authentication.AuthenticationProvider;
import constants.Coordinates;
import enums.StudentType;
import graphics.Assets;
import models.ButtonImpl;
import interfaces.Button;
import interfaces.State;

import java.awt.*;

public class PlayerCustomizationState implements State {

    public static Button playButton = new ButtonImpl(
            Coordinates.PLAYER_STATE_PLAY_BUTTON_X,
            Coordinates.PLAYER_STATE_PLAY_BUTTON_Y,
            Assets.buttonPlay);
    
    public static Button backToMenuButton = new ButtonImpl(
            Coordinates.PLAYER_STATE_BACK_BUTTON_X,
            Coordinates.PLAYER_STATE_BACK_BUTTON_Y,
            Assets.buttonBackToMenu);
    
    public static Button badBoyButton = new ButtonImpl(
            Coordinates.PLAYER_STATE_BAD_BOY_BUTTON_X,
            Coordinates.PLAYER_STATE_BAD_BOY_BUTTON_Y,
            Assets.buttonBadBoy);
    
    public static Button hotChickButton = new ButtonImpl(
            Coordinates.PLAYER_STATE_HOT_CHICK_BUTTON_X,
            Coordinates.PLAYER_STATE_HOT_CHICK_BUTTON_Y,
            Assets.buttonHotChick);
    
    public static Button nerdBoyButton = new ButtonImpl(
            Coordinates.PLAYER_STATE_NERD_BOY_BUTTON_X,
            Coordinates.PLAYER_STATE_NERD_BOY_BUTTON_Y,
            Assets.buttonNerdBoy);
    
    public static Button nerdLadyButton = new ButtonImpl(
            Coordinates.PLAYER_STATE_NERD_LADY_BUTTON_X,
            Coordinates.PLAYER_STATE_NERD_LADY_BUTTON_Y,
            Assets.buttonNerdLady);
    
    public static StudentType studentType;
    public static boolean isSelected = false;

	@Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.playerCustomization, 0, 0, Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT, null);
        graphics.drawImage(
                Assets.selectPlayer,
                Coordinates.PLAYER_STATE_TITLE_X,
                Coordinates.PLAYER_STATE_TITLE_Y,
                Coordinates.PLAYER_STATE_TITLE_WIDTH,
                Coordinates.PLAYER_STATE_TITLE_HEIGHT,
                null);

        Font textFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(textFont);
        graphics.setColor(Color.green);

        if (isSelected) {
            Rectangle coliderBox = setColiderBox(studentType);
            graphics.drawRect(coliderBox.x, coliderBox.y, coliderBox.width, coliderBox.height);
        }

        graphics.setColor(Color.black);
        if (AuthenticationProvider.currentUser != null) {
        	Font title = new Font("Comic Sans MS", Font.PLAIN, 20);
            graphics.setFont(title);
            graphics.setColor(Color.green);
    		graphics.fillRect(
    		        Coordinates.PLAYER_STATE_USER_BOX_X,
                    Coordinates.PLAYER_STATE_USER_BOX_Y,
                    Coordinates.PLAYER_STATE_USER_BOX_WIDTH,
                    Coordinates.PLAYER_STATE_USER_BOX_HEIGHT);
    		
    		graphics.setColor(Color.white);
    		graphics.drawString(
    		        AuthenticationProvider.currentUser.getUsername(),
                    Coordinates.PLAYER_STATE_USERNAME_X,
                    Coordinates.PLAYER_STATE_USERNAME_Y);
		}

        playButton.draw(graphics);
        backToMenuButton.draw(graphics);
        badBoyButton.draw(graphics);
        hotChickButton.draw(graphics);
        nerdBoyButton.draw(graphics);
        nerdLadyButton.draw(graphics);
    }

    @Override
    public void update() {}

    private Rectangle setColiderBox(StudentType studentType) {
        Rectangle coliderBox = null;

        switch (studentType) {
            case BAD_BOY:
                coliderBox = new Rectangle(
                        badBoyButton.getX() - Coordinates.PLAYER_STATE_COLIDER_BOX_MARGIN,
                        badBoyButton.getY() - Coordinates.PLAYER_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.PLAYER_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.PLAYER_STATE_COLIDER_BOX_HEIGHT);
                break;
            case HOT_CHICK:
                coliderBox = new Rectangle(
                        hotChickButton.getX() - Coordinates.PLAYER_STATE_COLIDER_BOX_MARGIN,
                        hotChickButton.getY() - Coordinates.PLAYER_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.PLAYER_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.PLAYER_STATE_COLIDER_BOX_HEIGHT);
                break;
            case NERD_BOY:
                coliderBox = new Rectangle(
                        nerdBoyButton.getX() - Coordinates.PLAYER_STATE_COLIDER_BOX_MARGIN,
                        nerdBoyButton.getY() - Coordinates.PLAYER_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.PLAYER_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.PLAYER_STATE_COLIDER_BOX_HEIGHT);
                break;
            case NERD_LADY:
                coliderBox = new Rectangle(
                        nerdLadyButton.getX() - Coordinates.PLAYER_STATE_COLIDER_BOX_MARGIN,
                        nerdLadyButton.getY() - Coordinates.PLAYER_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.PLAYER_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.PLAYER_STATE_COLIDER_BOX_HEIGHT);
                break;
        }

        return coliderBox;
    }
}
