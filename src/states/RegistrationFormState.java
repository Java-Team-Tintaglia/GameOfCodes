package states;

import graphics.Assets;
import models.Button;
import repositories.UserRepository;
import utils.Constants;

import java.awt.*;

public class RegistrationFormState extends State {
    public static String registrationForm = "Registration Form";
    public static String userName = "Username:";
    public static String firstName = "First Name:";
    public static String lastName = "Last Name:";
    public static String password = "Password:";

    public static Button backToMenuButton = new Button(712, 510, Assets.buttonBackToMenu);
    public static Button registerButton = new Button(496, 510, Assets.buttonPlay);

    public static Rectangle userRect;
    public static Rectangle firstRect;
    public static Rectangle lastRect;
    public static Rectangle passRect;

    public static boolean isFieldSelected = false;
    public static String fieldType = null;

    public RegistrationFormState(UserRepository userRepository) {
        super(userRepository);
    }


    @Override
    public void draw(Graphics graphics) {
        int fieldNameX = 270;
        int fieldNameY = 190;
        int rectBoxX = 440;
        int rectBoxY = 162;

        graphics.drawImage(Assets.wall, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.fillRect(100, 40, 824, 450);

        Font title = new Font("Arial", Font.PLAIN, 35);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        graphics.drawString(registrationForm, 370, 90);

        Font fieldName = new Font("Arial", Font.PLAIN, 25);
        graphics.setFont(fieldName);
        graphics.drawString(userName, fieldNameX, fieldNameY);
        graphics.drawString(firstName, fieldNameX, fieldNameY + 60);
        graphics.drawString(lastName, fieldNameX, fieldNameY + 120);
        graphics.drawString(password, fieldNameX, fieldNameY + 180);

        graphics.fillRect(rectBoxX, rectBoxY, 300, 40);
        userRect = new Rectangle(rectBoxX, rectBoxY, 300, 40);
        graphics.fillRect(rectBoxX, rectBoxY + 60, 300, 40);
        firstRect = new Rectangle(rectBoxX, rectBoxY + 60, 300, 40);
        graphics.fillRect(rectBoxX, rectBoxY + 120, 300, 40);
        lastRect = new Rectangle(rectBoxX, rectBoxY + 120, 300, 40);
        graphics.fillRect(rectBoxX, rectBoxY + 180, 300, 40);
        passRect = new Rectangle(rectBoxX, rectBoxY + 180, 300, 40);

        graphics.setColor(Color.gray);
        if (isFieldSelected) {
            switch (fieldType) {
                case "user":
                    graphics.drawRect((int)userRect.getX() - 3, (int)userRect.getY() - 3, 306, 46);
                    break;
                case "first":
                    graphics.drawRect((int)firstRect.getX() - 3, (int)firstRect.getY() - 3, 306, 46);
                    break;
                case "last":
                    graphics.drawRect((int)lastRect.getX() - 3, (int)lastRect.getY() - 3, 306, 46);
                    break;
                case "pass":
                    graphics.drawRect((int)passRect.getX() - 3, (int)passRect.getY() - 3, 306, 46);
                    break;
            }
        }

        backToMenuButton.draw(graphics);
        registerButton.draw(graphics);
    }

    @Override
    public void update() {
    }
}