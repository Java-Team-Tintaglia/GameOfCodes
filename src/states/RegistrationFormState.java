package states;

import graphics.Assets;
import models.ButtonImpl;
import utils.Constants;
import utils.Coordinates;
import utils.Utils;

import java.awt.*;

public class RegistrationFormState extends State {
    private static final int TITLE_FONT_SIZE =35;
    private static final int FILED_NAME_FONT_SIZE = 25;
    private static final int INPUT_TEXT_FONT_SIZE = 20;

    public static ButtonImpl registerButton = new ButtonImpl(
            Coordinates.REGISTRATION_STATE_REGISTER_BUTTON_X,
            Coordinates.REGISTRATION_STATE_REGISTER_BUTTON_Y,
            Assets.buttonRegister);
    
    public static ButtonImpl backToMenuButton = new ButtonImpl(
            Coordinates.REGISTRATION_STATE_BACK_BUTTON_X,
            Coordinates.REGISTRATION_STATE_BACK_BUTTON_Y,
            Assets.buttonBackToMenu);
    
    public static Rectangle userRect = new Rectangle(
            Coordinates.REGISTRATION_STATE_USER_RECT_X,
            Coordinates.REGISTRATION_STATE_USER_RECT_Y,
            Coordinates.REGISTRATION_STATE_RECT_WIDTH,
            Coordinates.REGISTRATION_STATE_RECT_HEIGHT);
    
    public static Rectangle firstRect = new Rectangle(
            Coordinates.REGISTRATION_STATE_FIRST_RECT_X,
            Coordinates.REGISTRATION_STATE_FIRST_RECT_Y,
            Coordinates.REGISTRATION_STATE_RECT_WIDTH,
            Coordinates.REGISTRATION_STATE_RECT_HEIGHT);
    
    public static Rectangle lastRect = new Rectangle(
            Coordinates.REGISTRATION_STATE_LAST_RECT_X,
            Coordinates.REGISTRATION_STATE_LAST_RECT_Y,
            Coordinates.REGISTRATION_STATE_RECT_WIDTH,
            Coordinates.REGISTRATION_STATE_RECT_HEIGHT);
    
    public static Rectangle passRect = new Rectangle(
            Coordinates.REGISTRATION_STATE_PASS_RECT_X,
            Coordinates.REGISTRATION_STATE_PASS_RECT_Y,
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

        graphics.drawImage(Assets.background, 0,0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        
        graphics.fillRect(
               Coordinates.REGISTRATION_STATE_BLACK_BACKGROUND_X,
               Coordinates.REGISTRATION_STATE_BLACK_BACKGROUND_Y,
               Coordinates.REGISTRATION_STATE_BLACK_BACKGROUND_WIDTH,
               Coordinates.REGISTRATION_STATE_BLACK_BACKGROUND_HEIGHT);

        Font title = new Font("Arial", Font.PLAIN, TITLE_FONT_SIZE);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        
        graphics.drawString(
                registrationFormAsString,
                Coordinates.REGISTRATION_STATE_TITLE_X,
                Coordinates.REGISTRATION_STATE_TITLE_Y);

        Font fieldName = new Font("Arial", Font.PLAIN, FILED_NAME_FONT_SIZE);
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

        graphics.fillRect(userRect.x, userRect.y, userRect.width, userRect.height);
        graphics.fillRect(firstRect.x, firstRect.y, firstRect.width, firstRect.height);
        graphics.fillRect(lastRect.x, lastRect.y, lastRect.width, lastRect.height);
        graphics.fillRect(passRect.x, passRect.y, passRect.width, passRect.height);

        graphics.setColor(Color.gray);
        Rectangle coliderBox = setColiderBox(fieldType);
        graphics.drawRect(coliderBox.x, coliderBox.y, coliderBox.width, coliderBox.height);

        Font inputText = new Font("Arial", Font.BOLD, INPUT_TEXT_FONT_SIZE);
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
                        userRect.x - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        userRect.y - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_HEIGHT);
                break;
            case "first":
                rectangle = new Rectangle(
                        firstRect.x - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        firstRect.y - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_HEIGHT);
                break;
            case "last":
                rectangle = new Rectangle(
                        lastRect.x - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        lastRect.y - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_HEIGHT);
                break;
            case "pass":
                rectangle = new Rectangle(
                        passRect.x - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        passRect.y - Coordinates.REGISTRATION_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.REGISTRATION_STATE_COLIDER_BOX_HEIGHT);
                break;
        }

        return rectangle;
    }
}
