package states;

import authentication.AuthenticationProvider;
import authentication.Encoder;
import graphics.Assets;
import models.Button;
import utils.Constants;
import utils.Utils;

import java.awt.*;

public class EditProfileState extends State {
    private static int backToMenuButtonXCoord = 500;
    private static int backToMenuButtonYCoord = 510;
    private static int editButtonXCoord = 330;
    private static int editButtonYCoord = 510;
    private int fieldNameX = 220;
    private int fieldNameY = 208;
    private int rectBoxX = 420;
    private int rectBoxY = 182;
    private int backgroundRectXCoord = 100;
    private int backgroundRectYCoord = 40;
    private int backgroundRectWidth = 824;
    private int backgroundRectHeight = 450;
    private int titleFontSize = 35;
    private int fieldFontSize = 25;
    private int userInfoXCoord = 390;
    private int userInfoYCoord = 90;
    private int inputFieldRectXCoord = 300;
    private int inputFieldRectYCoord = 40;
    private int inputFieldWidth = 306;
    private int inputFieldHeight = 46;
    private int inputFieldFontSize = 20;
    public static StringBuilder firstName = new StringBuilder(
    										AuthenticationProvider.currentUser.getFirstName());
    public static StringBuilder lastName = new StringBuilder(
    										AuthenticationProvider.currentUser.getLastName());
    public static StringBuilder password = new StringBuilder(
    										Encoder.decryptPassword(AuthenticationProvider.currentUser.getPassword()));
    public static Button backToMenuButton = new Button(backToMenuButtonXCoord,
                                            backToMenuButtonYCoord, Assets.buttonBackToMenu);
    public static Button editButton = new Button(editButtonXCoord,
                                            editButtonYCoord, Assets.buttonEdit);

    public static Rectangle firstRect;
    public static Rectangle lastRect;
    public static Rectangle passRect;

    public static String fieldType = "first";

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.wall, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.fillRect(backgroundRectXCoord, backgroundRectYCoord, backgroundRectWidth, backgroundRectHeight);

        Font title = new Font("Arial", Font.PLAIN, titleFontSize);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        String userProfile = AuthenticationProvider.currentUser.getUsername();
        graphics.drawString("User: " + userProfile, userInfoXCoord, userInfoYCoord);

        Font fieldName = new Font("Arial", Font.PLAIN, fieldFontSize);
        graphics.setFont(fieldName);
        graphics.drawString("First Name:", fieldNameX, fieldNameY);
        graphics.drawString("Last Name:", fieldNameX, fieldNameY + 60);
        graphics.drawString("New Password:", fieldNameX, fieldNameY + 120);

        graphics.fillRect(rectBoxX, rectBoxY, inputFieldRectXCoord, inputFieldRectYCoord);
        firstRect = new Rectangle(rectBoxX, rectBoxY, inputFieldRectXCoord, inputFieldRectYCoord);
        graphics.fillRect(rectBoxX, rectBoxY + 60, inputFieldRectXCoord, inputFieldRectYCoord);
        lastRect = new Rectangle(rectBoxX, rectBoxY + 60, inputFieldRectXCoord, inputFieldRectYCoord);
        graphics.fillRect(rectBoxX, rectBoxY + 120, inputFieldRectXCoord, inputFieldRectYCoord);
        passRect = new Rectangle(rectBoxX, rectBoxY + 120, inputFieldRectXCoord, inputFieldRectYCoord);


        graphics.setColor(Color.gray);

        switch (fieldType) {
            case "first":
                graphics.drawRect((int)firstRect.getX() - 3,
                        (int)firstRect.getY() - 3,
                        inputFieldWidth,
                        inputFieldHeight);
                break;
            case "last":
                graphics.drawRect((int)lastRect.getX() - 3,
                        (int)lastRect.getY() - 3,
                        inputFieldWidth,
                        inputFieldHeight);
                break;
            case "pass":
                graphics.drawRect((int)passRect.getX() - 3,
                        (int)passRect.getY() - 3,
                        inputFieldWidth,
                        inputFieldHeight);
                break;
        }

        Font inputText = new Font("Arial", Font.BOLD, inputFieldFontSize);
        graphics.setFont(inputText);
        graphics.setColor(Color.black);
        graphics.drawString(firstName.toString(), rectBoxX + 30, rectBoxY + 26);
        graphics.drawString(lastName.toString(), rectBoxX + 30, rectBoxY + 86);
        graphics.drawString(Utils.hidePassword(password.length()), rectBoxX + 30, rectBoxY + 146);

        backToMenuButton.draw(graphics);
        editButton.draw(graphics);
    }

    @Override
    public void update() {
    }
}
