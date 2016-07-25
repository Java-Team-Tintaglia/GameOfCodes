package states;

import graphics.Assets;
import models.Button;
import utils.Constants;
import utils.Utils;

import java.awt.*;

public class LoginFormState extends State {

    private static final int LOGIN_BUTTON_COORD_X = 440;
    private static final int LOGIN_BUTTON_COORD_Y = 320;
    private static final int BACK_BUTTON_COORD_X = 712;
    private static final int BACK_BUTTON_COORD_Y = 510;
    private static final int USERNAME_FIELD_COORD_X = 335;
    private static final int USERNAME_FIELD_COORD_Y = 180;
    private static final int PASSWORD_FIELD_COORD_X = 335;
    private static final int PASSWORD_FIELD_COORD_Y = 243;
    private static final int FIELD_WIDTH = 346;
    private static final int FIELD_HEIGHT = 49;
    private static final int COLIDER_BOX_MARGIN = 3;
    private static final int COLIDER_BOX_WIDTH = FIELD_WIDTH + 6;
    private static final int COLIDER_BOX_HEIGHT = FIELD_HEIGHT + 6;
    private static final int LOGIN_FORM_COORD_X = 250;
    private static final int LOGIN_FORM_COORD_Y = 100;
    private static final int LOGIN_FORM_WIDTH = 524;
    private static final int LOGIN_FORM_HEIGHT = 300;
    private static final int USERNAME_COORD_X = 400;
    private static final int USERNAME_COORD_Y = 212;
    private static final int PASSWORD_COORD_X = 400;
    private static final int PASSWORD_COORD_Y = 275;

    public static Button loginButton = new Button(LOGIN_BUTTON_COORD_X, LOGIN_BUTTON_COORD_Y, Assets.buttonLogIn);
    public static Button backToMenuButton = new Button(BACK_BUTTON_COORD_X, BACK_BUTTON_COORD_Y, Assets.buttonBackToMenu);
    public static Rectangle userRect = new Rectangle(USERNAME_FIELD_COORD_X, USERNAME_FIELD_COORD_Y, FIELD_WIDTH, FIELD_HEIGHT);
    public static Rectangle passRect = new Rectangle(PASSWORD_FIELD_COORD_X, PASSWORD_FIELD_COORD_Y, FIELD_WIDTH, FIELD_HEIGHT);
    public static StringBuilder username = new StringBuilder();
    public static StringBuilder password = new StringBuilder();
    public static String fieldType = "user";

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.background, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.login, LOGIN_FORM_COORD_X, LOGIN_FORM_COORD_Y, LOGIN_FORM_WIDTH, LOGIN_FORM_HEIGHT, null);

        graphics.setColor(Color.gray);
        Rectangle coliderBox = setColiderBox(fieldType);
        graphics.drawRect(coliderBox.x, coliderBox.y, coliderBox.width, coliderBox.height);

        Font inputText = new Font("Arial", Font.BOLD, 20);
        graphics.setFont(inputText);
        graphics.setColor(Color.white);
        graphics.drawString(username.toString(), USERNAME_COORD_X, USERNAME_COORD_Y);
        graphics.drawString(Utils.hidePassword(password.length()), PASSWORD_COORD_X, PASSWORD_COORD_Y);

        backToMenuButton.draw(graphics);
        loginButton.draw(graphics);
    }

    @Override
    public void update() {}

    private Rectangle setColiderBox(String fieldType) {
        Rectangle coliderBox = null;

        switch (fieldType) {
            case "user":
                coliderBox = new Rectangle(
                        (int)userRect.getX() - COLIDER_BOX_MARGIN,
                        (int)userRect.getY() - COLIDER_BOX_MARGIN,
                        COLIDER_BOX_WIDTH,
                        COLIDER_BOX_HEIGHT);
                break;
            case "pass":
                coliderBox = new Rectangle(
                        (int)passRect.getX() - COLIDER_BOX_MARGIN,
                        (int)passRect.getY() - COLIDER_BOX_MARGIN,
                        COLIDER_BOX_WIDTH,
                        COLIDER_BOX_HEIGHT);
                break;
        }

        return coliderBox;
    }
}
