package states;

import graphics.Assets;
import models.ButtonImpl;
import utils.Utils;

import java.awt.*;

import constants.Common;
import constants.Coordinates;

public class LoginFormState extends State {

    private static final int INPUT_TEXT_FONT_SIZE = 20;
    public static ButtonImpl loginButton = new ButtonImpl(
            Coordinates.LOGIN_STATE_LOGIN_BUTTON_X,
            Coordinates.LOGIN_STATE_LOGIN_BUTTON_Y,
            Assets.buttonLogIn);
    
    public static ButtonImpl backToMenuButton = new ButtonImpl(
            Coordinates.LOGIN_STATE_BACK_BUTTON_X,
            Coordinates.LOGIN_STATE_BACK_BUTTON_Y,
            Assets.buttonBackToMenu);
    
    public static Rectangle userRect = new Rectangle(
            Coordinates.LOGIN_STATE_USERNAME_FIELD_X,
            Coordinates.LOGIN_STATE_USERNAME_FIELD_Y,
            Coordinates.LOGIN_STATE_FIELD_WIDTH,
            Coordinates.LOGIN_STATE_FIELD_HEIGHT);
    
    public static Rectangle passRect = new Rectangle(
            Coordinates.LOGIN_STATE_PASSWORD_FIELD_X,
            Coordinates.LOGIN_STATE_PASSWORD_FIELD_Y,
            Coordinates.LOGIN_STATE_FIELD_WIDTH,
            Coordinates.LOGIN_STATE_FIELD_HEIGHT);
    
    public static StringBuilder username = new StringBuilder();
    public static StringBuilder password = new StringBuilder();
    public static String fieldType = "user";

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.background, 0, 0, Common.SCREEN_WIDTH, Common.SCREEN_HEIGHT, null);
        graphics.drawImage(
                Assets.login,
                Coordinates.LOGIN_STATE_LOGIN_FORM_X,
                Coordinates.LOGIN_STATE_LOGIN_FORM_Y,
                Coordinates.LOGIN_STATE_LOGIN_FORM_WIDTH,
                Coordinates.LOGIN_STATE_LOGIN_FORM_HEIGHT,
                null);

        graphics.setColor(Color.gray);
        Rectangle coliderBox = setColiderBox(fieldType);
        graphics.drawRect(coliderBox.x, coliderBox.y, coliderBox.width, coliderBox.height);

        Font inputText = new Font("Arial", Font.BOLD, INPUT_TEXT_FONT_SIZE);
        graphics.setFont(inputText);
        graphics.setColor(Color.white);
        graphics.drawString(
                username.toString(),
                Coordinates.LOGIN_STATE_USERNAME_X,
                Coordinates.LOGIN_STATE_USERNAME_Y);
        graphics.drawString(
                Utils.hidePassword(password.length()),
                Coordinates.LOGIN_STATE_PASSWORD_X,
                Coordinates.LOGIN_STATE_PASSWORD_Y);

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
                        userRect.x - Coordinates.LOGIN_STATE_COLIDER_BOX_MARGIN,
                        userRect.y - Coordinates.LOGIN_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.LOGIN_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.LOGIN_STATE_COLIDER_BOX_HEIGHT);
                break;
            case "pass":
                coliderBox = new Rectangle(
                        passRect.x - Coordinates.LOGIN_STATE_COLIDER_BOX_MARGIN,
                        passRect.y - Coordinates.LOGIN_STATE_COLIDER_BOX_MARGIN,
                        Coordinates.LOGIN_STATE_COLIDER_BOX_WIDTH,
                        Coordinates.LOGIN_STATE_COLIDER_BOX_HEIGHT);
                break;
        }

        return coliderBox;
    }
}
