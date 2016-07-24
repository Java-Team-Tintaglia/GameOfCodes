package states;

import graphics.Assets;
import models.Button;
import utils.Constants;

import java.awt.*;
import java.util.StringTokenizer;

public class ErrorMessageState extends State {
	
    private String message;
    private State nextState;
    private static int okButtonXCoord = 450;
    private static int okButtonYCoord = 500;
    private int messagePositionX = 250;
    private int messagePositionY = 400;
    private int titleFontSize = 20;

    public static Button okButton = new Button(okButtonXCoord, okButtonYCoord, Assets.buttonOk);

    public ErrorMessageState(String message, State nextState) {
        this.message = message;
        this.nextState = nextState;
    }

    @Override
    public void draw(Graphics graphics) {


        graphics.drawImage(Assets.error, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

        Font titleFont = new Font("Arial", Font.BOLD, titleFontSize);
        graphics.setFont(titleFont);
        graphics.setColor(Color.black);


        StringTokenizer tokens = new StringTokenizer(this.message, " ");


        int lineLen = 0;
        String line = "";
        while (tokens.hasMoreTokens()) {
            String word = tokens.nextToken();

            if (lineLen + word.length() > 40) {
                lineLen = 0;
                graphics.drawString(line, messagePositionX, messagePositionY);
                line = "";
                messagePositionY += 30;
            }
            line += (word + " ");
            lineLen += word.length();
        }
        graphics.drawString(line, messagePositionX, messagePositionY);

        okButton.draw(graphics);
    }

    @Override
    public void update() {

    }

	public State getNextState() {
		return nextState;
	}

}
