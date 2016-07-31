package states;

import authentication.AuthenticationProvider;
import authentication.Encoder;
import graphics.Assets;
import models.ButtonImpl;
import utils.Constants;
import utils.Utils;

import java.awt.*;

public class EditProfileState extends State {

    private static final int OFFSET_LAST_NAME =60;
    private static final int OFFSET_NEW_PASSWORD =120;
    private static final int OFFSET_RECTBOX_Y=60;
    private static final int RECTANGLE_MARGIN=3;


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
    public static ButtonImpl backToMenuButton = new ButtonImpl(backToMenuButtonXCoord,
                                            backToMenuButtonYCoord, Assets.buttonBackToMenu);
    public static ButtonImpl editButton = new ButtonImpl(editButtonXCoord,
                                            editButtonYCoord, Assets.buttonEdit);

    public static Rectangle firstRect;
    public static Rectangle lastRect;
    public static Rectangle passRect;

    public static String fieldType = "first";

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.wall,0,0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.fillRect(backgroundRectXCoord, backgroundRectYCoord, backgroundRectWidth, backgroundRectHeight);

        Font title = new Font("Arial", Font.PLAIN, titleFontSize);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        String userProfile = AuthenticationProvider.currentUser.getUsername();
        graphics.drawString("User: " + userProfile, userInfoXCoord, userInfoYCoord);

        Font fieldName = new Font("Arial", Font.PLAIN, fieldFontSize);
        graphics.setFont(fieldName);
        graphics.drawString("First Name:", fieldNameX, fieldNameY);
        graphics.drawString("Last Name:", fieldNameX, fieldNameY + OFFSET_LAST_NAME);
        graphics.drawString("New Password:", fieldNameX, fieldNameY + OFFSET_NEW_PASSWORD);

        graphics.fillRect(rectBoxX, rectBoxY, inputFieldRectXCoord, inputFieldRectYCoord);
        firstRect = new Rectangle(rectBoxX, rectBoxY, inputFieldRectXCoord, inputFieldRectYCoord);
        graphics.fillRect(rectBoxX, rectBoxY + OFFSET_RECTBOX_Y, inputFieldRectXCoord, inputFieldRectYCoord);
        lastRect = new Rectangle(rectBoxX, rectBoxY + OFFSET_RECTBOX_Y, inputFieldRectXCoord, inputFieldRectYCoord);
        graphics.fillRect(rectBoxX, rectBoxY + OFFSET_RECTBOX_Y*2, inputFieldRectXCoord, inputFieldRectYCoord);
        passRect = new Rectangle(rectBoxX, rectBoxY + OFFSET_RECTBOX_Y*2, inputFieldRectXCoord, inputFieldRectYCoord);


        graphics.setColor(Color.gray);

        switch (fieldType) {
            case "first":
                graphics.drawRect(firstRect.x - RECTANGLE_MARGIN,
                        firstRect.y - RECTANGLE_MARGIN,
                        inputFieldWidth,
                        inputFieldHeight);
                break;
            case "last":
                graphics.drawRect(lastRect.x - RECTANGLE_MARGIN,
                        lastRect.y - RECTANGLE_MARGIN,
                        inputFieldWidth,
                        inputFieldHeight);
                break;
            case "pass":
                graphics.drawRect(passRect.x - RECTANGLE_MARGIN,
                        passRect.y - RECTANGLE_MARGIN,
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
