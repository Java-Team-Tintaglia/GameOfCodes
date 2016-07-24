package states;

import graphics.Assets;
import models.Button;
import utils.Constants;
import utils.Utils;

import java.awt.*;

public class RegistrationFormState extends State {

    private static final int BUTTON_COORD_X = 496;
    private static final int BUTTON_COORD_Y = 510;
    private static final int BUTTON_DISTANCE_BY_X = 216;
    private static final int FIELD_COORD_X = 440;
    private static final int FIELD_COORD_Y = 162;
    private static final int FIELD_WIDTH = 300;
    private static final int FIELD_HEIGHT = 40;
    private static final int FIELD_DISTANCE_BY_Y = 60;
    private static final int COLIDER_BOX_MARGIN = 3;
    private static final int COLIDER_BOX_WIDTH = 306;
    private static final int COLIDER_BOX_HEIGHT = 46;
    private static final int FIELD_NAME_COORD_X = 270;
    private static final int FIELD_NAME_COORD_Y = 190;
    private static final int TEXT_IN_FIELD_COORD_X = FIELD_COORD_X + 30;
    private static final int TEXT_IN_FIELD_COORD_Y = FIELD_COORD_Y + 25;
    private static final int TEXT_IN_FIELD_DISTANCE_BY_Y = 60;
    private static final int TITLE_COORD_X = 370;
    private static final int TITLE_COORD_Y = 90;
    private static final int BLACK_BACKGROUND_COORD_X = 100;
    private static final int BLACK_BACKGROUND_COORD_Y = 40;
    private static final int BLACK_BACKGROUND_WIDTH = 824;
    private static final int BLACK_BACKGROUND_HEIGHT = 450;

    public static Button registerButton = new Button(BUTTON_COORD_X, BUTTON_COORD_Y, Assets.buttonRegister);
    public static Button backToMenuButton = new Button(BUTTON_COORD_X + BUTTON_DISTANCE_BY_X, BUTTON_COORD_Y, Assets.buttonBackToMenu);
    public static Rectangle userRect = new Rectangle(FIELD_COORD_X, FIELD_COORD_Y, FIELD_WIDTH, FIELD_HEIGHT);
    public static Rectangle firstRect = new Rectangle(FIELD_COORD_X, FIELD_COORD_Y + FIELD_DISTANCE_BY_Y, FIELD_WIDTH, FIELD_HEIGHT);
    public static Rectangle lastRect = new Rectangle(FIELD_COORD_X, FIELD_COORD_Y + 2 * FIELD_DISTANCE_BY_Y, FIELD_WIDTH, FIELD_HEIGHT);
    public static Rectangle passRect = new Rectangle(FIELD_COORD_X, FIELD_COORD_Y + 3 * FIELD_DISTANCE_BY_Y, FIELD_WIDTH, FIELD_HEIGHT);
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

        graphics.drawImage(Assets.background, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.fillRect(BLACK_BACKGROUND_COORD_X, BLACK_BACKGROUND_COORD_Y, BLACK_BACKGROUND_WIDTH, BLACK_BACKGROUND_HEIGHT);

        Font title = new Font("Arial", Font.PLAIN, 35);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        graphics.drawString(registrationFormAsString, TITLE_COORD_X, TITLE_COORD_Y);

        Font fieldName = new Font("Arial", Font.PLAIN, 25);
        graphics.setFont(fieldName);
        graphics.drawString(usernameAsString, FIELD_NAME_COORD_X, FIELD_NAME_COORD_Y);
        graphics.drawString(firstNameAsString, FIELD_NAME_COORD_X, FIELD_NAME_COORD_Y + FIELD_DISTANCE_BY_Y);
        graphics.drawString(lastNameAsString, FIELD_NAME_COORD_X, FIELD_NAME_COORD_Y + 2 * FIELD_DISTANCE_BY_Y);
        graphics.drawString(passwordAsString, FIELD_NAME_COORD_X, FIELD_NAME_COORD_Y + 3 * FIELD_DISTANCE_BY_Y);

        graphics.fillRect(userRect.x, userRect.y, userRect.width, userRect.height);
        graphics.fillRect(firstRect.x, firstRect.y, firstRect.width, firstRect.height);
        graphics.fillRect(lastRect.x, lastRect.y, lastRect.width, lastRect.height);
        graphics.fillRect(passRect.x, passRect.y, passRect.width, passRect.height);

        graphics.setColor(Color.gray);
        Rectangle coliderBox = setColiderBox(fieldType);
        graphics.drawRect(coliderBox.x, coliderBox.y, coliderBox.width, coliderBox.height);

        Font inputText = new Font("Arial", Font.BOLD, 20);
        graphics.setFont(inputText);
        graphics.setColor(Color.black);

        graphics.drawString(username.toString(), TEXT_IN_FIELD_COORD_X, TEXT_IN_FIELD_COORD_Y);
        graphics.drawString(firstName.toString(), TEXT_IN_FIELD_COORD_X, TEXT_IN_FIELD_COORD_Y + TEXT_IN_FIELD_DISTANCE_BY_Y);
        graphics.drawString(lastName.toString(), TEXT_IN_FIELD_COORD_X, TEXT_IN_FIELD_COORD_Y + 2 * TEXT_IN_FIELD_DISTANCE_BY_Y);
        graphics.drawString(Utils.hidePassword(password.length()), TEXT_IN_FIELD_COORD_X, TEXT_IN_FIELD_COORD_Y + 3 * TEXT_IN_FIELD_DISTANCE_BY_Y);

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
                        (int) userRect.getX() - COLIDER_BOX_MARGIN,
                        (int) userRect.getY() - COLIDER_BOX_MARGIN,
                        COLIDER_BOX_WIDTH,
                        COLIDER_BOX_HEIGHT);
                break;
            case "first":
                rectangle = new Rectangle(
                        (int) firstRect.getX() - COLIDER_BOX_MARGIN,
                        (int) firstRect.getY() - COLIDER_BOX_MARGIN,
                        COLIDER_BOX_WIDTH,
                        COLIDER_BOX_HEIGHT);
                break;
            case "last":
                rectangle = new Rectangle(
                        (int) lastRect.getX() - COLIDER_BOX_MARGIN,
                        (int) lastRect.getY() - COLIDER_BOX_MARGIN,
                        COLIDER_BOX_WIDTH,
                        COLIDER_BOX_HEIGHT);
                break;
            case "pass":
                rectangle = new Rectangle(
                        (int) passRect.getX() - COLIDER_BOX_MARGIN,
                        (int) passRect.getY() - COLIDER_BOX_MARGIN,
                        COLIDER_BOX_WIDTH,
                        COLIDER_BOX_HEIGHT);
                break;
        }

        return rectangle;
    }
}
