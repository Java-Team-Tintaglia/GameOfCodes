package states;

import authentication.AuthenticationProvider;
import constants.Coordinates;
import graphics.Assets;
import models.ButtonImpl;
import interfaces.Button;
import interfaces.State;

import java.awt.*;

public class MainMenuState implements State {

	private static final int BUTTON_LOG_IN_COORD_Y_OFFSET = 70;
	private static final int BUTTON_REGISTER_COORD_Y_OFFSET = 140;
	private static final int BUTTON_EXIT_COORD_Y_OFFSET = 210;
	private static final int BUTTON_PROFILE_COORD_Y_OFFSET = 70;
	private static final int BUTTON_SCORE_COORD_Y_OFFSET = 70;
	private static final int BUTTON_LOG_OUT_COORD_Y_OFFSET = 210;
	private static final int TITLE_FONT_SIZE=20;
	private static final int RECTANGLE_WIDTH=180;
	private static final int RECTANGLE_HEIGHT=30;

	public static Button buttonLogIn = new ButtonImpl(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD + BUTTON_LOG_IN_COORD_Y_OFFSET, Assets.buttonLogIn);
	public static Button buttonRegister = new ButtonImpl(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD + BUTTON_REGISTER_COORD_Y_OFFSET,Assets.buttonRegister);
	public static Button buttonExit = new ButtonImpl(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD + BUTTON_EXIT_COORD_Y_OFFSET,Assets.buttonExit);
	 
    public static Button buttonStart = new ButtonImpl(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD, Assets.buttonStart);
	public static Button buttonProfile = new ButtonImpl(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD + BUTTON_PROFILE_COORD_Y_OFFSET, Assets.buttonProfile);
    public static Button buttonScore = new ButtonImpl(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD + BUTTON_SCORE_COORD_Y_OFFSET, Assets.buttonScore);
    public static Button buttonLogOut = new ButtonImpl(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD + BUTTON_LOG_OUT_COORD_Y_OFFSET, Assets.buttonLogOut);

	@Override
    public void draw(Graphics graphics) {

    	graphics.drawImage(Assets.mainMenu, 0, 0, Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT, null);

    	Font title = new Font("Comic Sans MS", Font.PLAIN, TITLE_FONT_SIZE);
        graphics.setFont(title);

    	if (AuthenticationProvider.currentUser != null) {
    		graphics.setColor(Color.green);
    		graphics.fillRect(Coordinates.RECTANGLE_X_COORD, Coordinates.RECTANGLE_Y_COORD, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
    		
    		graphics.setColor(Color.white);
    		graphics.drawString(AuthenticationProvider.currentUser.getUsername(), Coordinates.USER_NAME_X_COORD, Coordinates.USER_NAME_Y_COORD);
    		 buttonStart.draw(graphics);
			 buttonProfile.draw(graphics);
    	     buttonScore.draw(graphics);
			 buttonLogOut.draw(graphics);
		} else {
			buttonLogIn.draw(graphics);
			buttonRegister.draw(graphics);
			buttonExit.draw(graphics);
		}	
    }

    @Override
    public void update() {
    }

}
