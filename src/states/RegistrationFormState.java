package states;

import graphics.Assets;
import models.ButtonImpl;
import interfaces.Button;
import interfaces.State;
import utils.Utils;

import java.awt.*;

import constants.Coordinates;
import constants.Fonts;

public class RegistrationFormState implements State {

    public static Button registerButton = new ButtonImpl(
            Coordinates.REGISTRATION_STATE_REGISTER_BUTTON_X,
            Coordinates.REGISTRATION_STATE_REGISTER_BUTTON_Y,
            Assets.buttonRegister);
    
    public static Button backToMenuButton = new ButtonImpl(
            Coordinates.REGISTRATION_STATE_BACK_BUTTON_X,
            Coordinates.REGISTRATION_STATE_BACK_BUTTON_Y,
            Assets.buttonBackToMenu);
    
    public static Rectangle usernameRectangle = new Rectangle(
            Coordinates.REGISTRATION_STATE_USERNAME_RECT_X,
            Coordinates.REGISTRATION_STATE_USERNAME_RECT_Y,
            Coordinates.REGISTRATION_STATE_RECT_WIDTH,
            Coordinates.REGISTRATION_STATE_RECT_HEIGHT);
    
    public static Rectangle firstNameRectangle = new Rectangle(
            Coordinates.REGISTRATION_STATE_FIRST_NAME_RECT_X,
            Coordinates.REGISTRATION_STATE_FIRST_NAME_RECT_Y,
            Coordinates.REGISTRATION_STATE_RECT_WIDTH,
            Coordinates.REGISTRATION_STATE_RECT_HEIGHT);
    
    public static Rectangle lastNameRectangle = new Rectangle(
            Coordinates.REGISTRATION_STATE_LAST_NAME_RECT_X,
            Coordinates.REGISTRATION_STATE_LAST_NAME_RECT_Y,
            Coordinates.REGISTRATION_STATE_RECT_WIDTH,
            Coordinates.REGISTRATION_STATE_RECT_HEIGHT);
    
    public static Rectangle passwordRectangle = new Rectangle(
            Coordinates.REGISTRATION_STATE_PASSWORD_RECT_X,
            Coordinates.REGISTRATION_STATE_PASSWORD_RECT_Y,
            Coordinates.REGISTRATION_STATE_RECT_WIDTH,
            Coordinates.REGISTRATION_STATE_RECT_HEIGHT);
    
    public static StringBuilder username = new StringBuilder();
    public static StringBuilder firstName = new StringBuilder();
    public static StringBuilder lastName = new StringBuilder();
    public static StringBuilder password = new StringBuilder();
    public static String fieldType = "user";

    @Override
    public void draw(Graphics graphics) {
        String registrationFormAsString = "Registration Form";
        String usernameAsString = "Username:";
        String firstNameAsString = "First Name:";
        String lastNameAsString = "Last Name:";
        String passwordAsString = "Password:";

        graphics.drawImage(Assets.background, 0,0, Coordinates.SCREEN_WIDTH, Coordinates.SCREEN_HEIGHT, null);
        
        graphics.fillRect(
               Coordinates.REGISTRATION_STATE_BLACK_BACKGROUND_X,
               Coordinates.REGISTRATION_STATE_BLACK_BACKGROUND_Y,
               Coordinates.REGISTRATION_STATE_BLACK_BACKGROUND_WIDTH,
               Coordinates.REGISTRATION_STATE_BLACK_BACKGROUND_HEIGHT);

        Font title = new Font(Fonts.ARIAL_FONT, Font.PLAIN, Fonts.TITLE_FONT_SIZE);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        
        graphics.drawString(
                registrationFormAsString,
                Coordinates.REGISTRATION_STATE_TITLE_X,
                Coordinates.REGISTRATION_STATE_TITLE_Y);

        Font fieldName = new Font(Fonts.ARIAL_FONT, Font.PLAIN, Fonts.INPUT_FIELD_FONT_SIZE);
        graphics.setFont(fieldName);
        
        graphics.drawString(
                usernameAsString,
                Coordinates.REGISTRATION_STATE_USERNAME_X,
                Coordinates.REGISTRATION_STATE_USERNAME_Y);
        
        graphics.drawString(
                firstNameAsString,
                Coordinates.REGISTRATION_STATE_FIRST_NAME_X,
                Coordinates.REGISTRATION_STATE_FIRST_NAME_Y);
        
        graphics.drawString(
                lastNameAsString,
                Coordinates.REGISTRATION_STATE_LAST_NAME_X,
                Coordinates.REGISTRATION_STATE_LAST_NAME_Y);
        
        graphics.drawString(
                passwordAsString,
                Coordinates.REGISTRATION_STATE_PASSWORD_X,
                Coordinates.REGISTRATION_STATE_PASSWORD_Y);

        graphics.fillRect(usernameRectangle.x, usernameRectangle.y, usernameRectangle.width, usernameRectangle.height);
        graphics.fillRect(firstNameRectangle.x, firstNameRectangle.y, firstNameRectangle.width, firstNameRectangle.height);
        graphics.fillRect(lastNameRectangle.x, lastNameRectangle.y, lastNameRectangle.width, lastNameRectangle.height);
        graphics.fillRect(passwordRectangle.x, passwordRectangle.y, passwordRectangle.width, passwordRectangle.height);

        graphics.setColor(Color.gray);
        Rectangle coliderBox = setColiderBox(fieldType);
        graphics.drawRect(coliderBox.x, coliderBox.y, coliderBox.width, coliderBox.height);

        Font inputText = new Font(Fonts.ARIAL_FONT, Font.BOLD, Fonts.INPUT_FIELD_FONT_SIZE);
        graphics.setFont(inputText);
        graphics.setColor(Color.black);

        graphics.drawString(
                username.toString(),
                Coordinates.REGISTRATION_STATE_USER_STRING_X,
                Coordinates.REGISTRATION_STATE_USER_STRING_Y);
        
        graphics.drawString(
                firstName.toString(),
                Coordinates.REGISTRATION_STATE_FIRST_STRING_X,
                Coordinates.REGISTRATION_STATE_FIRST_STRING_Y);
        
        graphics.drawString(
                lastName.toString(),
                Coordinates.REGISTRATION_STATE_LAST_STRING_X,
                Coordinates.REGISTRATION_STATE_LAST_STRING_Y);
        
        graphics.drawString(
                Utils.hidePassword(password.length()),
                Coordinates.REGISTRATION_STATE_PASS_STRING_X,
                Coordinates.REGISTRATION_STATE_PASS_STRING_Y);

        backToMenuButton.draw(graphics);
        registerButton.draw(graphics);
    }

    @Override
    public void update() {}

    private Rectangle setColiderBox(String fieldType) {
        Rectangle rectangle = null;

        switch (fieldType) {
            case "user":
                rectangle = new Rectangle(
                        usernameRectangle.x - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        usernameRectangle.y - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_HEIGHT);
                break;
            case "first":
                rectangle = new Rectangle(
                        firstNameRectangle.x - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        firstNameRectangle.y - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_HEIGHT);
                break;
            case "last":
                rectangle = new Rectangle(
                        lastNameRectangle.x - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        lastNameRectangle.y - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_HEIGHT);
                break;
            case "pass":
                rectangle = new Rectangle(
                        passwordRectangle.x - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        passwordRectangle.y - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_HEIGHT);
                break;
        }

        return rectangle;
    }
}
