package states;

import graphics.Assets;
import models.Button;
import utils.Constants;
import utils.Utils;

import java.awt.*;

public class LoginFormState extends State {

    public static StringBuilder username = new StringBuilder();
    public static StringBuilder password = new StringBuilder();

    public static Button backToMenuButton = new Button(712, 510, Assets.buttonBackToMenu);
    public static Button loginButton = new Button(440, 320, Assets.buttonLogIn);

    public static Rectangle userRect = new Rectangle(335, 180, 346, 49);
    public static Rectangle passRect = new Rectangle(335, 243, 346, 49);

    public static String fieldType = "user";

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.background, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.login, 250, 100, 524, 300, null);

        graphics.setColor(Color.gray);

        switch (fieldType) {
            case "user":
                graphics.drawRect((int)userRect.getX() - 3 , (int)userRect.getY() - 3, (int)userRect.getWidth() + 6, (int)userRect.getHeight() + 6);
                break;
            case "pass":
                graphics.drawRect((int)passRect.getX() - 3 , (int)passRect.getY() - 3, (int)passRect.getWidth() + 6, (int)passRect.getHeight() + 6);
                break;
        }

        Font inputText = new Font("Arial", Font.BOLD, 20);
        graphics.setFont(inputText);
        graphics.setColor(Color.white);
        graphics.drawString(username.toString(), 400, 212);
        graphics.drawString(Utils.hidePassword(password.length()), 400, 275);

        backToMenuButton.draw(graphics);
        loginButton.draw(graphics);
    }

    @Override
    public void update() {
    }
}
