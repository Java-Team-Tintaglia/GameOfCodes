package states;

import authentication.AuthenticationProvider;
import authentication.Encoder;
import graphics.Assets;
import models.Button;
import utils.Constants;
import utils.Utils;

import java.awt.*;

public class EditProfileState extends State {

    public static StringBuilder firstName = new StringBuilder(
    										AuthenticationProvider.currentUser.getFirstName());
    
    public static StringBuilder lastName = new StringBuilder(
    										AuthenticationProvider.currentUser.getLastName());
    
    public static StringBuilder password = new StringBuilder(
    										Encoder.decryptPassword(AuthenticationProvider.currentUser.getPassword()));

    public static Button backToMenuButton = new Button(500, 510, Assets.buttonBackToMenu);
    public static Button editButton = new Button(330, 510, Assets.buttonEdit);

    public static Rectangle firstRect;
    public static Rectangle lastRect;
    public static Rectangle passRect;

    public static String fieldType = "first";


    @Override
    public void draw(Graphics graphics) {
        int fieldNameX = 220;
        int fieldNameY = 208;
        int rectBoxX = 420;
        int rectBoxY = 182;

        graphics.drawImage(Assets.wall, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.fillRect(100, 40, 824, 450);

        Font title = new Font("Arial", Font.PLAIN, 35);
        graphics.setFont(title);
        graphics.setColor(Color.white);
        String userProfile = AuthenticationProvider.currentUser.getUsername();
        graphics.drawString("User: " + userProfile, 390, 90);

        Font fieldName = new Font("Arial", Font.PLAIN, 25);
        graphics.setFont(fieldName);
        graphics.drawString("First Name:", fieldNameX, fieldNameY);
        graphics.drawString("Last Name:", fieldNameX, fieldNameY + 60);
        graphics.drawString("New Password:", fieldNameX, fieldNameY + 120);

        graphics.fillRect(rectBoxX, rectBoxY, 300, 40);
        firstRect = new Rectangle(rectBoxX, rectBoxY, 300, 40);
        graphics.fillRect(rectBoxX, rectBoxY + 60, 300, 40);
        lastRect = new Rectangle(rectBoxX, rectBoxY + 60, 300, 40);
        graphics.fillRect(rectBoxX, rectBoxY + 120, 300, 40);
        passRect = new Rectangle(rectBoxX, rectBoxY + 120, 300, 40);


        graphics.setColor(Color.gray);

        switch (fieldType) {
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

        Font inputText = new Font("Arial", Font.BOLD, 20);
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
    	if (!AuthenticationProvider.currentUser.getUsername().equals(firstName.toString())) {
    		firstName = new StringBuilder(
					AuthenticationProvider.currentUser.getFirstName());
		}
    	
    	if (!AuthenticationProvider.currentUser.getUsername().equals(lastName.toString())) {
    		lastName = new StringBuilder(
					AuthenticationProvider.currentUser.getLastName());
		}
    	
    	if (!AuthenticationProvider.currentUser.getUsername().equals(password.toString())) {
    		password = new StringBuilder(
					AuthenticationProvider.currentUser.getPassword());
		}
    	
    }
}
