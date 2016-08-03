package states;

import constants.Coordinates;
import constants.Fonts;
import graphics.Assets;
import models.ButtonImpl;
import interfaces.AuthenticationProvider;
import interfaces.Button;
import interfaces.State;

import java.awt.*;

public class MainMenuState implements State {
	
	public static Button buttonLogIn = new ButtonImpl(
												Coordinates.MAIN_MENU_STATE_BUTTON_X, 
												Coordinates.MAIN_MENU_STATE_LOGIN_BUTTON_Y, 
												Assets.buttonLogIn);
	
	public static Button buttonRegister = new ButtonImpl(
												Coordinates.MAIN_MENU_STATE_BUTTON_X, 
												Coordinates.MAIN_MENU_STATE_REGISTER_BUTTON_LOGIN_Y,
												Assets.buttonRegister);
	
	public static Button buttonExit = new ButtonImpl(
												Coordinates.MAIN_MENU_STATE_BUTTON_X, 
												Coordinates.MAIN_MENU_STATE_EXIT_BUTTON_LOGIN_Y,
												Assets.buttonExit);
	 
    public static Button buttonStart = new ButtonImpl(
    											Coordinates.MAIN_MENU_STATE_BUTTON_X, 
    											Coordinates.MAIN_MENU_STATE_START_BUTTON_LOGIN_Y, 
    											Assets.buttonStart);
    
	public static Button buttonProfile = new ButtonImpl(
												Coordinates.MAIN_MENU_STATE_BUTTON_X, 
												Coordinates.MAIN_MENU_STATE_PROFILE_BUTTON_LOGIN_Y, 
												Assets.buttonProfile);
	
    public static Button buttonScore = new ButtonImpl(
    											Coordinates.MAIN_MENU_STATE_BUTTON_X, 
    											Coordinates.MAIN_MENU_STATE_SCORE_BUTTON_LOGIN_Y, 
    											Assets.buttonScore);
    
    public static Button buttonLogOut = new ButtonImpl(
    											Coordinates.MAIN_MENU_STATE_BUTTON_X, 
    											Coordinates.MAIN_MENU_STATE_LOGOUT_BUTTON_LOGIN_Y, 
    											Assets.buttonLogOut);

    private AuthenticationProvider authenticationProvider;
	
	public MainMenuState(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}
    
	@Override
    public void draw(Graphics graphics) {

    	graphics.drawImage(Assets.mainMenu, 0, 0, Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT, null);
    	Font title = new Font(Fonts.COMIS_SANS_FONT, Font.PLAIN, Fonts.TEXT_FONT_SIZE);
        graphics.setFont(title);

    	if (this.authenticationProvider.getLoggedUser() != null) {
    		graphics.setColor(Color.green);
    		graphics.fillRect(
    				Coordinates.MAIN_MENU_STATE_USER_RECTANGLE_X, 
    				Coordinates.MAIN_MENU_STATE_USER_RECTANGLE_Y, 
    				Coordinates.MAIN_MENU_STATE_USER_RECTANGLE_WIDTH, 
    				Coordinates.MAIN_MENU_STATE_USER_RECTANGLE_HEIGHT);
    		
    		graphics.setColor(Color.white);
    		graphics.drawString(
    				this.authenticationProvider.getLoggedUser().getUsername(), 
    				Coordinates.MAIN_MENU_STATE_USERNAME_X, 
    				Coordinates.MAIN_MENU_STATE_USERNAME_Y);
    		
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
    public void update() {}
}
