package states;

import authentication.Encoder;
import constants.Coordinates;
import constants.Fonts;
import graphics.Assets;
import models.ButtonImpl;
import interfaces.AuthenticationProvider;
import interfaces.Button;
import interfaces.State;
import utils.Utils;

import java.awt.*;

public class EditProfileState implements State {

    public static Button backToMenuButton = new ButtonImpl(
										    		Coordinates.EDIT_PROFILE_STATE_BACK_BUTTON_X,
										    		Coordinates.EDIT_PROFILE_STATE_BACK_BUTTON_Y, 
										    		Assets.buttonBackToMenu);
    
    public static Button editButton = new ButtonImpl(
    											Coordinates.EDIT_PROFILE_STATE_EDIT_BUTTON_X,
    											Coordinates.EDIT_PROFILE_STATE_EDIT_BUTTON_Y, 
    											Assets.buttonEdit);

    public static StringBuilder firstName;
    public static StringBuilder lastName;
    public static StringBuilder password;
    public static Rectangle firstNameRectangle;
    public static Rectangle lastNameRectangle;
    public static Rectangle passwordRectangle;
    public static String fieldType = "first";
    
    private AuthenticationProvider authenticationProvider;
    
    public EditProfileState(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
		firstName = new StringBuilder(
				this.authenticationProvider.getLoggedUser().getFirstName());
		lastName = new StringBuilder(
				this.authenticationProvider.getLoggedUser().getLastName());
		password = new StringBuilder(
				Encoder.decryptPassword(this.authenticationProvider.getLoggedUser().getPassword()));
	}


    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.background, 0, 0, Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT, null);
        
        graphics.fillRect(
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FORM_X, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FORM_Y, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FORM_WIDTH, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FORM_HEIGHT);

        Font title = new Font(Fonts.ARIAL_FONT, Font.PLAIN, Fonts.TITLE_FONT_SIZE);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        
        String username = this.authenticationProvider.getLoggedUser().getUsername();
        graphics.drawString(
        		"User: " + username, 
        		Coordinates.EDIT_PROFILE_STATE_USER_INFO_X, 
        		Coordinates.EDIT_PROFILE_STATE_USER_INFO_Y);
        
        Font fieldName = new Font(Fonts.ARIAL_FONT, Font.PLAIN, Fonts.TEXT_FONT_SIZE);
        graphics.setFont(fieldName);
        
        graphics.drawString(
        		"First Name:", 
        		Coordinates.EDIT_PROFILE_STATE_FIELD_NAME_X, 
        		Coordinates.EDIT_PROFILE_STATE_FIELD_NAME_Y);
        
        graphics.drawString(
        		"Last Name:", 
        		Coordinates.EDIT_PROFILE_STATE_FIELD_NAME_X, 
        		Coordinates.EDIT_PROFILE_STATE_FIELD_NAME_Y 
        		+ Coordinates.EDIT_PROFILE_STATE_OFFSET);
        
        graphics.drawString(
        		"New Password:", 
        		Coordinates.EDIT_PROFILE_STATE_FIELD_NAME_X, 
        		Coordinates.EDIT_PROFILE_STATE_FIELD_NAME_Y 
        		+ 2 * Coordinates.EDIT_PROFILE_STATE_OFFSET);

        graphics.fillRect(
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_X, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_Y, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_WIDTH, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_HEIGHT);
        
        firstNameRectangle = new Rectangle(
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_X, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_Y, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_WIDTH, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_HEIGHT);
        
        graphics.fillRect(
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_X, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_Y 
        		+ Coordinates.EDIT_PROFILE_STATE_OFFSET, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_WIDTH, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_HEIGHT);
        
        lastNameRectangle = new Rectangle(
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_X, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_Y 
        		+ Coordinates.EDIT_PROFILE_STATE_OFFSET, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_WIDTH, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_HEIGHT);
        
        graphics.fillRect(
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_X, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_Y + 
        		Coordinates.EDIT_PROFILE_STATE_OFFSET * 2, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_WIDTH, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_HEIGHT);
        
        passwordRectangle = new Rectangle(
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_X, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_Y 
        		+ Coordinates.EDIT_PROFILE_STATE_OFFSET * 2, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_WIDTH, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_HEIGHT);

        graphics.setColor(Color.gray);

        switch (fieldType) {
            case "first":
                graphics.drawRect(
                		firstNameRectangle.x - Coordinates.EDIT_PROFILE_STATE_RECTANGLE_MARGIN,
                        firstNameRectangle.y - Coordinates.EDIT_PROFILE_STATE_RECTANGLE_MARGIN,
                        Coordinates.EDIT_PROFILE_STATE_HIGHLIGHTED_FIELD_WIDTH,
                        Coordinates.EDIT_PROFILE_STATE_HIGHLIGHTED_FIELD_HEIGTH);
                break;
            case "last":
                graphics.drawRect(
                		lastNameRectangle.x - Coordinates.EDIT_PROFILE_STATE_RECTANGLE_MARGIN,
                        lastNameRectangle.y - Coordinates.EDIT_PROFILE_STATE_RECTANGLE_MARGIN,
                        Coordinates.EDIT_PROFILE_STATE_HIGHLIGHTED_FIELD_WIDTH,
                        Coordinates.EDIT_PROFILE_STATE_HIGHLIGHTED_FIELD_HEIGTH);
                break;
            case "pass":
                graphics.drawRect(
                		passwordRectangle.x - Coordinates.EDIT_PROFILE_STATE_RECTANGLE_MARGIN,
                        passwordRectangle.y - Coordinates.EDIT_PROFILE_STATE_RECTANGLE_MARGIN,
                        Coordinates.EDIT_PROFILE_STATE_HIGHLIGHTED_FIELD_WIDTH,
                        Coordinates.EDIT_PROFILE_STATE_HIGHLIGHTED_FIELD_HEIGTH);
                break;
        }

        Font inputText = new Font("Arial", Font.BOLD, Fonts.TEXT_FONT_SIZE);
        graphics.setFont(inputText);
        graphics.setColor(Color.black);
        
        graphics.drawString(
        		firstName.toString(), 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_X 
        		+ Coordinates.EDIT_PROFILE_STATE_TEXT_OFFSET, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_Y 
        		+ Coordinates.EDIT_PROFILE_STATE_FIRST_NAME_MARGIN);
        
        graphics.drawString(
        		lastName.toString(), 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_X 
        		+ Coordinates.EDIT_PROFILE_STATE_TEXT_OFFSET, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_Y 
        		+ Coordinates.EDIT_PROFILE_STATE_LAST_NAME_MARGIN);
        
        graphics.drawString(
        		Utils.hidePassword(password.length()), 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_X 
        		+ Coordinates.EDIT_PROFILE_STATE_TEXT_OFFSET, 
        		Coordinates.EDIT_PROFILE_STATE_INPUT_FIELD_Y 
        		+ Coordinates.EDIT_PROFILE_STATE_PASSWORD_MARGIN);

        backToMenuButton.draw(graphics);
        editButton.draw(graphics);
    }

    @Override
    public void update() {
    }
}
