package states;

import authentication.AuthenticationProvider;
import enums.StudentType;
import graphics.Assets;
import models.Button;
import utils.Constants;

import java.awt.*;

public class PlayerCustomizationState extends State {

    private static final int PLAY_BUTTON_COORD_X = 496;
    private static final int PLAY_BUTTON_COORD_Y = 510;
    private static final int BACK_BUTTON_COORD_X = 712;
    private static final int BACK_BUTTON_COORD_Y = 510;
    private static final int BAD_BOY_BUTTON_COORD_X = 74;
    private static final int BAD_BOY_BUTTON_COORD_Y = 300;
    private static final int HOT_CHICK_BUTTON_COORD_X = 316;
    private static final int HOT_CHICK_BUTTON_COORD_Y = 300;
    private static final int NERD_BOY_BUTTON_COORD_X = 558;
    private static final int NERD_BOY_BUTTON_COORD_Y = 300;
    private static final int NERD_LADY_BUTTON_COORD_X = 800;
    private static final int NERD_LADY_BUTTON_COORD_Y = 300;
    private static final int TITLE_COORD_X = 362;
    private static final int TITLE_COORD_Y = 30;
    private static final int TITLE_WIDTH = 300;
    private static final int TITLE_HEIGHT = 70;
    private static final int USER_BOX_COORD_X = 880;
    private static final int USER_BOX_COORD_Y = 10;
    private static final int USER_BOX_WIDTH = 150;
    private static final int USER_BOX_HEIGHT = 30;
    private static final int USERNAME_COORD_X = 900;
    private static final int USERNAME_COORD_Y = 30;
    private static final int COLIDER_BOX_WIDTH = 170;
    private static final int COLIDER_BOX_HEIGHT = 60;
    private static final int BAD_BOY_COLIDER_BOX_COORD_X = 64;
    private static final int BAD_BOY_COLIDER_BOX_COORD_Y = 290;
    private static final int HOT_CHICK_COLIDER_BOX_COORD_X = 306;
    private static final int HOT_CHICK_COLIDER_BOX_COORD_Y = 290;
    private static final int NERD_BOY_COLIDER_BOX_COORD_X = 548;
    private static final int NERD_BOY_COLIDER_BOX_COORD_Y = 290;
    private static final int NERD_LADY_COLIDER_BOX_COORD_X = 790;
    private static final int NERD_LADY_COLIDER_BOX_COORD_Y = 290;

    public static Button playButton = new Button(PLAY_BUTTON_COORD_X, PLAY_BUTTON_COORD_Y, Assets.buttonPlay);
    public static Button backToMenuButton = new Button(BACK_BUTTON_COORD_X, BACK_BUTTON_COORD_Y, Assets.buttonBackToMenu);
    public static Button badBoyButton = new Button(BAD_BOY_BUTTON_COORD_X, BAD_BOY_BUTTON_COORD_Y, Assets.buttonBadBoy);
    public static Button hotChickButton = new Button(HOT_CHICK_BUTTON_COORD_X, HOT_CHICK_BUTTON_COORD_Y, Assets.buttonHotChick);
    public static Button nerdBoyButton = new Button(NERD_BOY_BUTTON_COORD_X, NERD_BOY_BUTTON_COORD_Y, Assets.buttonNerdBoy);
    public static Button nerdLadyButton = new Button(NERD_LADY_BUTTON_COORD_X, NERD_LADY_BUTTON_COORD_Y, Assets.buttonNerdLady);
    public static StudentType studentType;
    public static boolean isSelected = false;

	@Override
    public void draw(Graphics graphics) {
        graphics.drawImage(Assets.playerCustomization, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        graphics.drawImage(Assets.selectPlayer, TITLE_COORD_X, TITLE_COORD_Y, TITLE_WIDTH, TITLE_HEIGHT, null);

        Font textFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(textFont);
        graphics.setColor(Color.green);

        if (isSelected) {
            Rectangle coliderBox = setColiderBox(studentType);
            graphics.drawRect(coliderBox.x, coliderBox.y, coliderBox.width, coliderBox.height);
        }

        graphics.setColor(Color.black);
        if (AuthenticationProvider.currentUser != null) {
        	Font title = new Font("Comic Sans MS", Font.PLAIN, 20);
            graphics.setFont(title);
            graphics.setColor(Color.green);
    		graphics.fillRect(USER_BOX_COORD_X, USER_BOX_COORD_Y, USER_BOX_WIDTH, USER_BOX_HEIGHT);
    		
    		graphics.setColor(Color.white);
    		graphics.drawString(AuthenticationProvider.currentUser.getUsername(), USERNAME_COORD_X, USERNAME_COORD_Y);
		}

        playButton.draw(graphics);
        backToMenuButton.draw(graphics);
        badBoyButton.draw(graphics);
        hotChickButton.draw(graphics);
        nerdBoyButton.draw(graphics);
        nerdLadyButton.draw(graphics);
    }

    @Override
    public void update() {}

    private Rectangle setColiderBox(StudentType studentType) {
        Rectangle coliderBox = null;

        switch (studentType) {
            case BAD_BOY:
                coliderBox = new Rectangle(BAD_BOY_COLIDER_BOX_COORD_X, BAD_BOY_COLIDER_BOX_COORD_Y, COLIDER_BOX_WIDTH, COLIDER_BOX_HEIGHT);
                break;
            case HOT_CHICK:
                coliderBox = new Rectangle(HOT_CHICK_COLIDER_BOX_COORD_X, HOT_CHICK_COLIDER_BOX_COORD_Y, COLIDER_BOX_WIDTH, COLIDER_BOX_HEIGHT);
                break;
            case NERD_BOY:
                coliderBox = new Rectangle(NERD_BOY_COLIDER_BOX_COORD_X, NERD_BOY_COLIDER_BOX_COORD_Y, COLIDER_BOX_WIDTH, COLIDER_BOX_HEIGHT);
                break;
            case NERD_LADY:
                coliderBox = new Rectangle(NERD_LADY_COLIDER_BOX_COORD_X, NERD_LADY_COLIDER_BOX_COORD_Y, COLIDER_BOX_WIDTH, COLIDER_BOX_HEIGHT);
                break;
        }

        return coliderBox;
    }
}
