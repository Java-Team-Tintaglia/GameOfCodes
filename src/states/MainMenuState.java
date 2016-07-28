package states;

import authentication.AuthenticationProvider;
import graphics.Assets;
import models.Button;
import utils.Constants;
import utils.Coordinates;

import java.awt.*;

public class MainMenuState extends State {

	private static final int BUTTON_LOG_IN_COORD_Y_OFFSET = 70;
	private static final int BUTTON_REGISTER_COORD_Y_OFFSET = 140;
	private static final int BUTTON_EXIT_COORD_Y_OFFSET = 210;
	private static final int BUTTON_PROFILE_COORD_Y_OFFSET = 70;
	private static final int BUTTON_SCORE_COORD_Y_OFFSET = 70;
	private static final int BUTTON_LOG_OUT_COORD_Y_OFFSET = 210;
	private static final int TITLE_FONT_SIZE=20;
	private static final int RECTANGLE_WIDTH=180;
	private static final int RECTANGLE_HEIGHT=30;

	public static Button buttonLogIn = new Button(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD + BUTTON_LOG_IN_COORD_Y_OFFSET, Assets.buttonLogIn);
	public static Button buttonRegister = new Button(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD + BUTTON_REGISTER_COORD_Y_OFFSET,Assets.buttonRegister);
	public static Button buttonExit = new Button(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD + BUTTON_EXIT_COORD_Y_OFFSET,Assets.buttonExit);
	 
    public static Button buttonStart = new Button(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD, Assets.buttonStart);
	public static Button buttonProfile = new Button(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD + BUTTON_PROFILE_COORD_Y_OFFSET, Assets.buttonProfile);
    public static Button buttonScore = new Button(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD + BUTTON_SCORE_COORD_Y_OFFSET, Assets.buttonScore);
    public static Button buttonLogOut = new Button(Coordinates.BUTTON_X_COORD, Coordinates.BUTTON_Y_COORD + BUTTON_LOG_OUT_COORD_Y_OFFSET, Assets.buttonLogOut);

	@Override
    public void draw(Graphics graphics) {





    	graphics.drawImage(Assets.mainMenu, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

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
