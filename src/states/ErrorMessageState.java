package states;

import graphics.Assets;
import models.Button;
import utils.Constants;
import utils.Coordinates;

import java.awt.*;
import java.util.StringTokenizer;

public class ErrorMessageState extends State {
    private static final int TITLE_FONT_SIZE = 20;
    private static final int MESSAGE_POSITION_X = 250;
    private String message;
    private State nextState;
    private int messagePositionY = 400;


    public static Button okButton = new Button(Coordinates.OK_BUTTON_X_COORD, Coordinates.OK_BUTTON_Y_COORD, Assets.buttonOk);

    public ErrorMessageState(String message, State nextState) {
        this.message = message;
        this.nextState = nextState;
    }

    @Override
    public void draw(Graphics graphics) {


        graphics.drawImage(Assets.error, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

        Font titleFont = new Font("Arial", Font.BOLD, TITLE_FONT_SIZE);
        graphics.setFont(titleFont);
        graphics.setColor(Color.black);


        StringTokenizer tokens = new StringTokenizer(this.message, " ");


        int lineLen = 0;
        String line = "";
        while (tokens.hasMoreTokens()) {
            String word = tokens.nextToken();

            if (lineLen + word.length() > 40) {
                lineLen = 0;
                graphics.drawString(line, MESSAGE_POSITION_X, messagePositionY);
                line = "";
                messagePositionY += 30;
            }
            line += (word + " ");
            lineLen += word.length();
        }
        graphics.drawString(line, MESSAGE_POSITION_X, messagePositionY);

        okButton.draw(graphics);
    }

    @Override
    public void update() {

    }

	public State getNextState() {
		return nextState;
	}

}
