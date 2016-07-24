package states;

import authentication.AuthenticationProvider;
import graphics.Assets;
import models.Button;
import utils.Constants;

import java.awt.*;

public class MainMenuState extends State {

	private static int buttonXCoord = 800;
	private static int buttonYCoord = 310;

	public static Button buttonLogIn = new Button(buttonXCoord, buttonYCoord + 70, Assets.buttonLogIn);
	public static Button buttonRegister = new Button(buttonXCoord, buttonYCoord + 140,Assets.buttonRegister);
	public static Button buttonExit = new Button(buttonXCoord, buttonYCoord + 210,Assets.buttonExit);
	 
    public static Button buttonStart = new Button(buttonXCoord, buttonYCoord, Assets.buttonStart);
	public static Button buttonProfile = new Button(buttonXCoord, buttonYCoord + 70, Assets.buttonProfile);
    public static Button buttonScore = new Button(buttonXCoord,buttonYCoord + 70, Assets.buttonScore);
    public static Button buttonLogOut = new Button(buttonXCoord, buttonYCoord + 210, Assets.buttonLogOut);

	@Override
    public void draw(Graphics graphics) {
		int titleFontSize = 20;
		int rectangleXCoord = 860;
		int rectangleYCoord = 10;
		int rectangleWidth = 180;
		int rectangleHeight = 30;
		int userNameXCoord = 900;
		int userNameYCoord = 30;

    	graphics.drawImage(Assets.mainMenu, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

    	Font title = new Font("Comic Sans MS", Font.PLAIN, titleFontSize);
        graphics.setFont(title);

    	if (AuthenticationProvider.currentUser != null) {
    		graphics.setColor(Color.green);
    		graphics.fillRect(rectangleXCoord, rectangleYCoord, rectangleWidth, rectangleHeight);
    		
    		graphics.setColor(Color.white);
    		graphics.drawString(AuthenticationProvider.currentUser.getUsername(), userNameXCoord, userNameYCoord);
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
