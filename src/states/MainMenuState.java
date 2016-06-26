package states;

import  java.awt.Graphics;

import authentication.AuthenticationProvider;
import graphics.Assets;
import models.Button;
import repositories.UserRepository;
import utils.Constants;

public class MainMenuState extends State {

	public static Button buttonLogin = new Button(800,380, Assets.buttonLogIn);
    public static Button buttonRegister = new Button(800,450,Assets.buttonRegister);
	
    public static Button buttonStart = new Button(800,380, Assets.buttonStart);
    public static Button buttonScore = new Button(800,450,Assets.buttonScore);
    
    public static Button buttonExit = new Button(800,520,Assets.buttonExit);
    

	public MainMenuState(UserRepository userRepository) {
		super(userRepository);
	}

	@Override
    public void draw(Graphics graphics) {
    	graphics.drawImage(Assets.mainMenu, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

    	if (AuthenticationProvider.currentUser != null) {
    		 buttonStart.draw(graphics);
    	     buttonScore.draw(graphics);
		} else {
			buttonLogin.draw(graphics);
			buttonRegister.draw(graphics);
		}
       
        
        buttonExit.draw(graphics);
    }

    @Override
    public void update() {
    }

}
