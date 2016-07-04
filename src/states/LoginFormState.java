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
    public static Button loginButton = new Button(496, 510, Assets.buttonLogIn);//TO DO change x and y

    public static Rectangle userRect;
    public static Rectangle passRect;

    public static String fieldType = "user";

    @Override
    public void draw(Graphics graphics) {
        int fieldNameX = 270;
        int fieldNameY = 200;
        int rectBoxX = 440;
        int rectBoxY = 172;

        graphics.drawImage(Assets.background, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.fillRect(100, 40, 824, 450);

        Font title = new Font("Arial", Font.PLAIN, 35);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        graphics.drawString("Login Form", 420, 90);

        Font fieldName = new Font("Arial", Font.PLAIN, 25);
        graphics.setFont(fieldName);
        graphics.drawString("Username:", fieldNameX, fieldNameY);
        graphics.drawString("Password:", fieldNameX, fieldNameY + 60);

        graphics.fillRect(rectBoxX, rectBoxY, 300, 40);
        userRect = new Rectangle(rectBoxX, rectBoxY, 300, 40);
        graphics.fillRect(rectBoxX, rectBoxY + 60, 300, 40);
        passRect = new Rectangle(rectBoxX, rectBoxY + 60, 300, 40);

        graphics.setColor(Color.gray);

        switch (fieldType) {
            case "user":
                graphics.drawRect((int)userRect.getX() - 3, (int)userRect.getY() - 3, 306, 46);
                break;
            case "pass":
                graphics.drawRect((int)passRect.getX() - 3, (int)passRect.getY() - 3, 306, 46);
                break;
        }

        Font inputText = new Font("Arial", Font.BOLD, 20);
        graphics.setFont(inputText);
        graphics.setColor(Color.black);
        graphics.drawString(username.toString(), rectBoxX + 30, rectBoxY + 25);
        graphics.drawString(Utils.hidePassword(password.length()), rectBoxX + 30, rectBoxY + 85);

        backToMenuButton.draw(graphics);
        loginButton.draw(graphics);
    }

    @Override
    public void update() {
    }
}
