package states;

import authentication.AuthenticationProvider;
import graphics.Assets;
import models.Button;
import utils.Constants;

import java.awt.*;

public class MainMenuState extends State {

	public static Button buttonLogIn = new Button(800,380, Assets.buttonLogIn);
	public static Button buttonRegister = new Button(800,450,Assets.buttonRegister);
	public static Button buttonExit = new Button(800,520,Assets.buttonExit);
	 
    public static Button buttonStart = new Button(800,310, Assets.buttonStart);
	public static Button buttonProfile = new Button(800, 380, Assets.buttonProfile);
    public static Button buttonScore = new Button(800,450,Assets.buttonScore);
    public static Button buttonLogOut = new Button(800,520, Assets.buttonLogOut);

	@Override
    public void draw(Graphics graphics) {
    	graphics.drawImage(Assets.mainMenu, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

    	Font title = new Font("Comic Sans MS", Font.PLAIN, 20);
        graphics.setFont(title);
        
    	
    	if (AuthenticationProvider.currentUser != null) {
    		graphics.setColor(Color.green);
    		graphics.fillRect(860, 10, 180, 30);
    		
    		graphics.setColor(Color.white);
    		graphics.drawString(AuthenticationProvider.currentUser.getUsername(), 900, 30);
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
